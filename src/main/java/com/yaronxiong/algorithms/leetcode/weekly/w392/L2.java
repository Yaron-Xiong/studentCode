package com.yaronxiong.algorithms.leetcode.weekly.w392;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        String xaxcd = l2.getSmallestString("kb", 16);
        System.out.println(xaxcd);

    }

    public String getSmallestString(String s, int k) {
        //每一位都到达最小
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            //每一位都尽可能移动到a
            if (array[i] == 'a') {
                continue;
            }
            int newChar1Int = array[i] - k < 'a' ? 'a' : array[i] - k;
            int cost1 = newChar1Int == 'a' ? array[i] - 'a' : k;
            int newChar2Int = array[i] + k > 'z' ? 'a' : array[i] + k;
            int cost2 = newChar2Int == 'a' ? 'z' - array[i] + 1 : k;
            if (newChar1Int <= newChar2Int && cost1 <= cost2) {
                if (newChar1Int == 'a') {
                    k -= array[i] - 'a';
                } else {
                    k = 0;
                }
                array[i] = (char) newChar1Int;
            } else if (newChar2Int == 'a') {
                k -= 'z' - array[i] + 1;
                array[i] = 'a';
            }
        }
        return new String(array);
    }
}
