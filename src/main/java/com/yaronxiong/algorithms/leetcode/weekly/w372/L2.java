package com.yaronxiong.algorithms.leetcode.weekly.w372;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(l2.minimumSteps("100100"));
    }

    public long minimumSteps(String s) {
        char[] array = s.toCharArray();
        int rightIndex = array.length;
        while (rightIndex - 1 >= 0 && array[rightIndex - 1] == '1') {
            rightIndex--;
        }
        long ans = 0;
        for (int i = rightIndex - 1; i >= 0; i--) {
            if (array[i] == '0') {
                continue;
            }
            ans += rightIndex - i - 1;
            rightIndex--;
        }
        return ans;
    }

    public void swap(char[] charArray, int a, int b) {
        char temp = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = temp;
    }
}
