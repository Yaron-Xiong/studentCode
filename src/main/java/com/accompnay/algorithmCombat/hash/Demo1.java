package com.accompnay.algorithmCombat.hash;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Accompany
 * LeetCode 242 题
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 解法1：
 * 对两个字符转化为数组后排序，如果两个数组不相等则不对
 * 解法2：
 * 创建26位数组，存储每个字符出现的次数，以及减去每次个字符出现的次数
 * 如果最后数组中存在值 不等于0 则不对
 * 解法3：
 * 为了解决非字母类型，则引用hash结构，但是会占用更多的内存空间
 */
public class Demo1 {
    /*
    //数组结构
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a'] +=1;
            arr[t.charAt(i)-'a'] -=1;
        }
        for (int i : arr) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }*/

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        System.out.println(demo1.isAnagram("anagram","nagaram"));
    }

    private boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        for (Integer value : map.values()) {
            if (value!=0){
                return false;
            }
        }
        return true;
    }
}
