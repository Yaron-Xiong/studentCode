package com.accompnay.leetcode;

public class Demo19 {

    public static void main(String[] args) {
        Demo19 demo19 = new Demo19();
        int test = demo19.test(4);
        System.out.println(test);
    }

    public int test(int n) {
        if (n <= 2) {
            return n;
        }
        return test(n - 1) + test(n - 2);
    }
}
