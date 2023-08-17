package com.accompnay.TopicAlgorithms.swordFingerOffer.search;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 简单
 * 341
 * 相关企业
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * <p>
 * 输入：s = ""
 * 输出：' '
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S50_FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.containsKey(key));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        S50_FirstUniqChar s50FirstUniqChar = new S50_FirstUniqChar();
        char abaccdeff = s50FirstUniqChar.firstUniqChar("loveleetcode");
        System.out.println(abaccdeff);
    }
}
