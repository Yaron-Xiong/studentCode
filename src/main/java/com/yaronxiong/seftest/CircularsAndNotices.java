package com.yaronxiong.seftest;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class CircularsAndNotices {
    @Data
    public static class Article {
        private int categoryId;
        private int id;
        private String title;
        private String operator;
        private String content;
        private int status;
        private int weight;
        private Date date;
        private Date updateTime;
        private String link;
        private String cover;
    }

    public static void main(String[] args) throws URISyntaxException, InterruptedException, IOException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        List<Article> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://10.17.1.75:3306/testSpringBoot?useSSL=false", "oss", "oss");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT a.CategoryId as categoryId, a.ArticleId AS Id , a.ArticleTitle AS title , a.UploadUserName AS Operator , a.ArticleContent AS content ," +
                    "a.Passed AS `Status` , a.Recommend AS Weight, a.UploadTime AS `date` ,a.UpdateTime AS UpdateTime, " +
                    "b.Link AS link , c.ResourceAliasName AS cover " +
                    " FROM GW_Article AS a  LEFT JOIN GW_LinkManager AS b ON a.ArticleId = b.RefArticleId LEFT JOIN GW_Resource AS c ON b.ResouceId = c.ResourceId  WHERE a.CategoryId IN(20209,20221,20215,20227,20239,20233,20245,20257,20251,20263,20275,20269);");
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                int categoryId = resultSet.getInt("categoryId");
                String title = resultSet.getString("title");
                String operator = resultSet.getString("Operator");
                String content = resultSet.getString("content");
                int status = resultSet.getInt("Status");
                int weight = resultSet.getInt("Weight");
                Date date = resultSet.getTimestamp("date");
                Date updateTime = resultSet.getTimestamp("UpdateTime");
                String link = resultSet.getString("link");
                String cover = resultSet.getString("cover");
                Article article = new Article();
                article.setId(id);
                article.setCategoryId(categoryId);
                article.setTitle(title);
                article.setOperator(operator);
                article.setContent(content);
                article.setStatus(status);
                article.setWeight(weight);
                article.setDate(date);
                article.setUpdateTime(updateTime);
                article.setLink(link);
                article.setCover(cover);
                list.add(article);
            }
        }

        list.sort(Comparator.comparing(Article::getDate));
        int curId = 70000;
        for (Article article : list) {
            article.setId(curId++);
        }

        List<String> sqlList = new ArrayList<>();
        List<String> sql2List = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Article article : list) {
            String sql = "insert into data (`Id`,`Mid`,`Alias`,`Value`,`Weight`,`CreateTime`,`UpdateTime`,`Operator`,`Status`,`PublishTime`) " +
                    "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');";
            String sql2 = "insert into data_public (`Id`,`Mid`,`Alias`,`Value`,`Weight`,`CreateTime`,`UpdateTime`,`Operator`,`Status`,`PublishTime`) " +
                    "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');";
            int midId = getMidId(article);
            int weight = 1;
            /*if (midId == 337 || midId == 338 || midId == 339) {
                weight = 1;
            }*/
            String jsonValue = getJsonValue(article, format);
            String cmd1 = String.format(sql, article.getId(), midId, getAlias(article), jsonValue, weight,
                    format.format(new Date()), format.format(article.getUpdateTime()), article.getOperator(), convertStatus(article), format.format(new Date()));
            String cmd2 = String.format(sql2, article.getId(), midId, getAlias(article), jsonValue, weight,
                    format.format(new Date()), format.format(article.getUpdateTime()), article.getOperator(), convertStatus(article), format.format(new Date()));
            sqlList.add(cmd1);
            sql2List.add(cmd2);
        }
        Path path = Paths.get("C:\\Users\\yaoyuanxiong\\Desktop\\sql\\circularsAndNotices", "data.sql");
        Path path1 = Paths.get("C:\\Users\\yaoyuanxiong\\Desktop\\sql\\circularsAndNotices", "data_public.sql");
        writeSql(sqlList, path);
        writeSql(sql2List, path1);
        System.out.println("hello");
    }

    private static String getJsonValue(Article article, SimpleDateFormat format) {
        int categoryId = article.getCategoryId();
        String title = article.getTitle();
        title = title.replace("'", "\\'");
        title = title.trim();
        String newLink = getLink(article);
        String cmsLink = getCMSLink(newLink);
        String cover = getCover(article);
        String cmsCover = getCMSCover(cover);
        if (categoryId == 20209 || categoryId == 20221 || categoryId == 20215) {
            return String.format("{\"title\":\"%s\",\"date\":\"%s\",\"old_link\":\"%s\",\"link\":\"%s\"}", title, format.format(article.getDate()), newLink, cmsLink);
        }
        if (categoryId == 20227 || categoryId == 20239 || categoryId == 20233) {
            return String.format("{\"title\":\"%s\",\"date\":\"%s\",\"old_link\":\"%s\",\"link\":\"%s\",\"desc\":\"%s\",\"old_cover\":\"%s\",\"cover\":\"%s\"}", title, format.format(article.getDate()), newLink, cmsLink, "", cover, cmsCover);
        }
        if (categoryId == 20245 || categoryId == 20257 || categoryId == 20251) {
            return String.format("{\"title\":\"%s\",\"old_cover\":\"%s\",\"cover\":\"%s\",\"old_link\":\"%s\",\"link\":\"%s\"}", title, cover, cmsCover, newLink, cmsLink);
        }
        if (categoryId == 20263 || categoryId == 20275 || categoryId == 20269) {
            return String.format("{\"title\":\"%s\",\"date\":\"%s\",\"old_link\":\"%s\",\"link\":\"%s\",\"old_cover\":\"%s\",\"cover\":\"%s\"}", title, format.format(article.getDate()), newLink, cmsLink, cover, cmsCover);
        }
        throw new RuntimeException(String.format("未知的categoryId类型 categoryId=[%s]", categoryId));
    }

    private static String getAlias(Article article) {
        int categoryId = article.getCategoryId();
        if (categoryId == 20209) {
            return "/baitianinfo/circularsAndNotices/zhCN/" + article.getId();
        }
        if (categoryId == 20221) {
            return "/baitianinfo/circularsAndNotices/zhTW/" + article.getId();
        }
        if (categoryId == 20215) {
            return "/baitianinfo/circularsAndNotices/en/" + article.getId();
        }

        if (categoryId == 20227) {
            return "/baitianinfo/news/zhCN/" + article.getId();
        }
        if (categoryId == 20239) {
            return "/baitianinfo/news/zhTW/" + article.getId();
        }
        if (categoryId == 20233) {
            return "/baitianinfo/news/en/" + article.getId();
        }

        if (categoryId == 20245) {
            return "/baitianinfo/financialReports/zhCN/" + article.getId();
        }
        if (categoryId == 20257) {
            return "/baitianinfo/financialReports/zhTW/" + article.getId();
        }
        if (categoryId == 20251) {
            return "/baitianinfo/financialReports/en/" + article.getId();
        }

        if (categoryId == 20263) {
            return "/baitianinfo/prospectus/zhCN/" + article.getId();
        }
        if (categoryId == 20275) {
            return "/baitianinfo/prospectus/zhTW/" + article.getId();
        }
        if (categoryId == 20269) {
            return "/baitianinfo/prospectus/en/" + article.getId();
        }
        throw new RuntimeException(String.format("未知的categoryId类型 categoryId=[%s]", categoryId));
    }

    private static int getMidId(Article article) {
        int categoryId = article.getCategoryId();
        if (categoryId == 20209) {
            //return 522;
            return 341;
        }
        if (categoryId == 20221) {
            //return 523;
            return 342;
        }
        if (categoryId == 20215) {
            //return 524;
            return 343;
        }

        if (categoryId == 20227) {
            //return 519;
            return 337;
        }
        if (categoryId == 20239) {
            //return 520;
            return 338;
        }
        if (categoryId == 20233) {
            //return 521;
            return 339;
        }

        if (categoryId == 20245) {
            //return 525;
            return 320;
        }
        if (categoryId == 20257) {
            //return 526;
            return 321;
        }
        if (categoryId == 20251) {
            //return 527;
            return 322;
        }

        if (categoryId == 20263) {
            //return 528;
            return 324;
        }
        if (categoryId == 20275) {
            //return 529;
            return 325;
        }
        if (categoryId == 20269) {
            //return 530;
            return 326;
        }

        throw new RuntimeException(String.format("未知的categoryId类型 categoryId=[%s]", categoryId));
    }

    private static void writeSql(List<String> sqlList, Path path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path), StandardCharsets.UTF_8));) {
            for (String s : sqlList) {
                writer.write(s);
                writer.newLine();
            }
            writer.flush();
        }
    }

    private static int convertStatus(Article article) {
        if (article.getStatus() == 0) {
            return 1;
        }
        if (article.getStatus() == 1) {
            return 3;
        }
        if (article.getStatus() == -1) {
            return 2;
        }
        throw new RuntimeException(String.format("出现异常未知的状态类型 status=[%s]", article.getStatus()));
    }

    private static String getCMSLink(String link) {
        int i = link.lastIndexOf("/");
        if (i < 0) {
            throw new RuntimeException(String.format("出异常辣 url不包含 / 源url =[%s]", link));
        }
        return "https://cms-static.100bt.com/upload/common_cms/baioo_static" + link.substring(i);
    }

    private static String getLink(Article article) {
        String link = article.getLink();
        if (link.startsWith("uploadFile")) {
            return "https://www.baioo.com.hk/" + link;
        }
        if (link.startsWith("/uploadFile")) {
            return "https://www.baioo.com.hk" + link;
        }
        return link.replace("www.baitianinfo.com", "www.baioo.com.hk");
    }

    private static String getCMSCover(String cover) {
        if (StringUtils.isEmpty(cover)) {
            return cover;
        }
        int i = cover.lastIndexOf("/");
        if (i < 0) {
            throw new RuntimeException(String.format("出异常辣 url不包含 / 源url =[%s]", cover));
        }
        return "https://cms-static.100bt.com/upload/common_cms/baioo_static" + cover.substring(i);
    }

    private static String getCover(Article article) {
        String cover = article.getCover();
        if (cover == null) {
            return "";
        }
        return "https://www.baioo.com.hk/investor/" + cover;
    }

}
