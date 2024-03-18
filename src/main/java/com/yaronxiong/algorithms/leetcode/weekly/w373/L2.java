package com.yaronxiong.algorithms.leetcode.weekly.w373;

import java.util.HashSet;
import java.util.Set;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        int i = l2.beautifulSubstrings("abba", 1);
        System.out.println(i);
    }

    public int beautifulSubstrings(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int vowels = 0;
            int consonants = 0;
            for (int j = i; j < n; j++) {
                if (set.contains(s.charAt(j))) {
                    vowels++;
                } else {
                    consonants++;
                }
                //比较 i~j 之间是否构成了美丽字符串
                if (vowels == consonants && (vowels * consonants) % k == 0) {
                    ans++;
                    System.out.println("i=" + i + " j=" + j);
                }
            }
        }
        return ans;
    }

}
