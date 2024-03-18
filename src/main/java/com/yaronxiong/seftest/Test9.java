package com.yaronxiong.seftest;


import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test9 {
    public static void main(String[] args) throws IOException {
        Test9 test9 = new Test9();
        Map<String, Long> month2Sum = new HashMap<>();
        Path path = Paths.get("C:\\Users\\yaoyuanxiong\\Desktop", "nginxLog");
        File file = path.toFile();
        if (file.isDirectory() && file.listFiles() != null) {
            for (File subFile : file.listFiles()) {
                List<String> nginxLogs = Files.readAllLines(subFile.toPath());
                test9.statistic(nginxLogs, month2Sum);
            }
        }
        System.out.println(month2Sum);
    }

    private void statistic(List<String> list, Map<String, Long> month2Sum) {
        for (String inputLine : list) {
            Pair<String, String> parseTest = parseTest(inputLine);
            if (parseTest.getValue().equals("/recharge")) {
                month2Sum.merge(parseTest.getKey(), 1L, Long::sum);
            }
        }
    }

    String parent = "(?<ip>\\d+\\.\\d+\\.\\d+\\.\\d+)( - - \\[)(?<time>\\d+/(?<month>\\S+)/.*]) (?<head>\"\\S+ (?<requestUrl>\\S+) \\S+)";
    Pattern r = Pattern.compile(parent);
    private Pair<String, String> parseTest(String text) {
        Matcher m = r.matcher(text);
        boolean b = m.find();
        if (!b) {
            throw new RuntimeException(String.format("解析出错 文本内容=[%s]", text));
        }
        return new Pair<>(m.group("month"), m.group("requestUrl"));
    }
}
