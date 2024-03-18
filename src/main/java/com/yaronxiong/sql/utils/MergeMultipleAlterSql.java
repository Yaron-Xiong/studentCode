package com.yaronxiong.sql.utils;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MergeMultipleAlterSql {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\yaoyuanxiong\\Desktop", "alter.sql");
        List<String> allLines = Files.readAllLines(path);
        List<String> statements = allLines.stream().filter(StringUtils::hasText).collect(Collectors.toList());
        Map<String, StringBuilder> mergedStatementsMap = new HashMap<>();
        List<String> alterDataSources = new ArrayList<>();
        for (String statement : statements) {
            if (isAlterDataSourceStatement(statement)){
                alterDataSources.add(statement);
                continue;
            }
            if (!isAlterTableStatement(statement)) {
                continue;
            }
            String tableName = getTableNameFromStatement(statement);

            mergedStatementsMap.putIfAbsent(tableName, new StringBuilder("ALTER TABLE " + tableName + " \n"));
            String newStr = statement.substring(statement.indexOf(tableName) + tableName.length());
            if (newStr.charAt(newStr.length() - 1) == ';') {
                newStr = newStr.substring(0, newStr.length() - 1);
            }
            mergedStatementsMap.get(tableName).append(newStr).append(",\n");
        }
        for (String alterDataSource : alterDataSources) {
            System.out.println(alterDataSource);
        }
        for (Map.Entry<String, StringBuilder> entry : mergedStatementsMap.entrySet()) {
            //System.out.println("\nMerged ALTER TABLE statements for table " + entry.getKey() + ": ");
            System.out.println(entry.getValue().substring(0, entry.getValue().length() - 2) + ";");
        }
    }

    public static String getTableNameFromStatement(String statement) {
        Pattern pattern = Pattern.compile("ALTER TABLE (?<name>`[^`]+`\\.`[^`]+`)");
        Matcher matcher = pattern.matcher(statement);

        if (matcher.find()) {
            return matcher.group("name");
        }

        throw new IllegalArgumentException("Table name not found in ALTER TABLE statement.");
    }
    public static boolean isAlterDataSourceStatement(String statement) {
        return statement.toUpperCase().contains("ALTER DATABASE");
    }
    public static boolean isAlterTableStatement(String statement) {
        return statement.toUpperCase().contains("ALTER TABLE");
    }
}
