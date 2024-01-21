package com.accompnay.TopicAlgorithms.leetcode.weekly.w374;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        int i = l3.countCompleteSubstrings("igigee", 2);
        System.out.println(i);
    }

    public int countCompleteSubstrings(String word, int k) {
        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            int[] chars = new int[26];
            long mask = 0;
            for (int j = i; j < word.length(); j++) {
                //检查i~j 是否满足条件
                if (j != i && Math.abs(word.charAt(j) - word.charAt(j - 1)) > 2) {
                    break;
                }
                int index = word.charAt(j) - 'a';
                chars[index]++;
                if (chars[index] > k) {
                    break;
                } else if (chars[index] == k) {
                    mask = (~(1L << (index))) & mask;
                } else {
                    mask |= 1 << index;
                }
                if ((j - i + 1) % k == 0 && mask == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }


}
