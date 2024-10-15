package com.yaronxiong.algorithms.leetcode.weekly.w417;

import java.util.HashMap;
import java.util.Map;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(l2.countOfSubstrings("ieaouqqieaouqq", 1));
    }

    public int countOfSubstrings(String word, int k) {
        //最小长度为  5+k
        //a,e,i,o,u
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        int n = word.length();
        int[] cnts = new int[6];
        int ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            Integer index = map.getOrDefault(word.charAt(r), 5);
            cnts[index]++;
            //左边界开始移动
            //什么时候动？
            //辅音超过了->绝对不合法
            while (l < r && cnts[5] > k) {
                Integer tempIndex = map.getOrDefault(word.charAt(l), 5);
                cnts[tempIndex]--;
                l++;
            }
            //检测
            if (cnts[5] == k && cnts[0] >= 1 && cnts[1] >= 1 && cnts[2] >= 1 && cnts[3] >= 1 && cnts[4] >= 1) {
                //检查前面有多少满足的元音
                //l->r
                int[] tempArr = new int[5];
                for (int temp = l; temp < r; temp++) {
                    ans++;
                    if (map.getOrDefault(word.charAt(temp), 5) == 5) {
                        break;
                    }
                    Integer tempIndex = map.get(word.charAt(temp));
                    tempArr[tempIndex]++;
                    int tempSize = cnts[tempIndex] - tempArr[tempIndex];
                    if (tempSize == 0) {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
