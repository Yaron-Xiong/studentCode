package com.accompnay.TopicAlgorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1156. 单字符重复子串的最大长度
 * 提示
 * 中等
 * 179
 * 相关企业
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1156_MaxRepOpt1 {
    public static void main(String[] args) {
        L1156_MaxRepOpt1 l1156MaxRepOpt1 = new L1156_MaxRepOpt1();
        int abcdef = l1156MaxRepOpt1.maxRepOpt1("abbbaaaaa");
        System.out.println(abcdef);
    }

    public int maxRepOpt1(String text) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            countMap.compute(text.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        int maxLength = 0;
        //窗口[i-j)
        int i = 0;
        while (i < text.length()) {
            int j = i + 1;
            while (j < text.length() && text.charAt(i) == text.charAt(j)) {
                j++;
            }
            //此时 j>length || j!=i
            if (j >= text.length() || (j - i) == countMap.get(text.charAt(i))) {
                int temp = countMap.get(text.charAt(i)) - (j - i) > 0 ? j - i + 1 : j - i;
                maxLength = Math.max(temp, maxLength);
                i = j;
                continue;
            }
            //跳过一个节点
            int k = j + 1;
            int count = countMap.get(text.charAt(i)) - (k - i);
            while (count > 0 && k < text.length() && text.charAt(i) == text.charAt(k)) {
                k++;
                count--;
            }
            maxLength = Math.max(k - i, maxLength);
            i++;
        }
        return maxLength;
    }
}
