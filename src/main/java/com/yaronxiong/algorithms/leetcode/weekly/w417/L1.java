package com.yaronxiong.algorithms.leetcode.weekly.w417;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        char c = l1.kthCharacter(5);
        System.out.println(String.valueOf(c));
    }

    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while (k > sb.length()) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'z') {
                    temp.append('a');
                } else {
                    char ca = (char) (sb.charAt(i)+1);
                    temp.append(ca);
                }
            }
            sb.append(temp);
        }
        return sb.charAt(k - 1);
    }
}
