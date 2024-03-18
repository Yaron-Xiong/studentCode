package com.yaronxiong.seftest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

public class Test2 {

    public static void main(String[] args) throws IOException {
        PrintStream outStream = new PrintStream(new FileOutputStream("E:\\data\\java\\md5-data\\eightDigitalTxt.txt", false));
        System.setOut(outStream);
        Test2 test2 = new Test2();
        int count = 8;
        new Thread(() -> {
            test2.dfs(count, '0', '1', new LinkedList<>());
        }).start();
        new Thread(() -> {
            test2.dfs(count, '2', '3', new LinkedList<>());
        }).start();
        new Thread(() -> {
            test2.dfs(count, '4', '5', new LinkedList<>());
        }).start();
        new Thread(() -> {
            test2.dfs(count, '6', '7', new LinkedList<>());
        }).start();
        new Thread(() -> {
            test2.dfs(count, '8', '9', new LinkedList<>());
        }).start();
    }

    // a->z
    // 65 -> "a"
    public void dfs(int curCount, int minValue, int maxValue, LinkedList<String> tempList) {
        if (curCount <= 0) {
            return;
        }
        int tempValue = minValue;
        while (tempValue <= maxValue) {
            tempList.add(String.valueOf((char) tempValue));
            dfs(curCount - 1, '0', '9', tempList);
            tempList.removeLast();
            tempValue++;
        }
    }

}
