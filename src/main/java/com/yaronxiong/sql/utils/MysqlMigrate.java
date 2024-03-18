package com.yaronxiong.sql.utils;

import net.lingala.zip4j.exception.ZipException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MysqlMigrate {

    public static void main(String[] args) throws IOException, ZipException, ParseException {
        Path path = Paths.get("C:\\Users\\yaoyuanxiong\\Desktop", "dump.sql");
        Collection<String> dumpTable = getDumpTable(path);
        newKeysCheck(dumpTable);
        dateCheck(dumpTable);
    }

    private static void dateCheck(Collection<String> dumpTable) {
        System.out.println("日期格式检查");
        for (String s : dumpTable) {
            if (s.contains("0000-00-00 00:00:00")) {
                System.err.println(String.format("错误：表中存在不合法的日期格式 field=[%s] date=[%s]", "0000-00-00 00:00:00", s));
            }
        }
        System.out.println("日期格式检查结束");
    }

    private static void charSetCheck(Collection<String> dumpTable) {
        System.out.println("开始检查字符集");
        Pattern pattern = Pattern.compile("CHARSET=(?<charset>\\w+)");
        for (String s : dumpTable) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String engine = matcher.group("charset");
                System.out.println(engine);
                if (!engine.contains("utf8")) {
                    System.err.println(String.format("错误：表中存在不兼容的字符集 field=[%s] line=[%s]", engine, s));
                }
            }
        }
        System.out.println("结束检查字符集");
    }

    private static void engineCheck(Collection<String> dumpTable) {
        System.out.println("开始检查引擎");
        Pattern pattern = Pattern.compile("ENGINE=(?<engine>\\w+)");
        for (String s : dumpTable) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String engine = matcher.group("engine");
                System.out.println(engine);
                if (!engine.contains("InnoDB")) {
                    System.err.println(String.format("错误：表中存在非InnoDB引擎 field=[%s] line=[%s]", engine, s));
                }
            }
        }
        System.out.println("结束检查引擎");
    }

    private static void newKeysCheck(Collection<String> dumpTable) throws IOException {
        System.out.println("开始检查新增关键词");
        Set<String> newKeys = getNewKeys();
        Pattern pattern = Pattern.compile("`(?<field>\\w+)`");
        for (String s : dumpTable) {
            //用正则提取
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String field = matcher.group("field").toUpperCase();
                //System.out.println(field);
                if (newKeys.contains(field)) {
                    System.err.println(String.format("错误：表中存在新增关键词 field=[%s] line=[%s]", field, s));
                }
            }
        }
        System.out.println("结束检查新增关键词");
    }

    private static Collection<String> getDumpTable(Path path) throws IOException {
        return new ArrayList<>(Files.readAllLines(path));
    }

    private static Set<String> getNewKeys() throws IOException {
        Path path = Paths.get("C:\\Users\\yaoyuanxiong\\Desktop", "新增关键词");
        return new HashSet<>(Files.readAllLines(path));
    }

}
