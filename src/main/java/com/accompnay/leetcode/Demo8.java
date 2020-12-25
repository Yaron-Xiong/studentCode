package com.accompnay.leetcode;

public class Demo8 {
    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        int ab = demo8.calculate("");
        System.out.println(ab);
    }
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        char[] array = s.toCharArray();
        for (char c : array) {
            switch (c) {
                case 'A':
                    x = x * 2 + y;
                    break;
                case 'B':
                    y = y * 2 + x;
                    break;
                default:
                    break;
            }
        }
        return x + y;
    }
}
