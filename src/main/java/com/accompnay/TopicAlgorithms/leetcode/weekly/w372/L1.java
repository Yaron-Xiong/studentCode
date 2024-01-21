package com.accompnay.TopicAlgorithms.leetcode.weekly.w372;

import java.io.ObjectInput;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        System.out.println(l1.findMinimumOperations("a", "a", "a"));
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        //一位一位比较
        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int index = minLen - 1;
        while (index >= 0) {
            if (s1.charAt(index) == s2.charAt(index) && s1.charAt(index) == s3.charAt(index)) {
                index--;
            }
            else if (index < 1) {
                return -1;
            }else {
                minLen = index;
                index--;
            }
        }
        return s1.length() - minLen + s2.length() - minLen + s3.length() - minLen;
    }
}
