package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 1163. 按字典序排在最后的子串
 * 提示
 * 困难
 * 144
 * 相关企业
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："tcode"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 4 * 105
 * s 仅含有小写英文字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/last-substring-in-lexicographical-order/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1163_LastSubstring {
    public static void main(String[] args) {
        L1163_LastSubstring l1163LastSubstring = new L1163_LastSubstring();
        System.out.println(l1163LastSubstring.lastSubstring("dcbadcbadd"));
    }

    public String lastSubstring(String s) {
        char[] charArray = s.toCharArray();
        char maxChar = charArray[0];
        int maxCharIndex = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] > maxChar) {
                maxChar = s.charAt(i);
                maxCharIndex = i;
            }
        }
        //可能存在多个maxChar对比每个maxChar构成的字串那个大
        int left = maxCharIndex;
        int right = left + 1;
        while (right < charArray.length) {
            if (charArray[right] != maxChar) {
                right++;
                continue;
            }
            //比对left & right构成的字串谁大
            int k = 1;
            while (right + k < charArray.length && charArray[left + k] == charArray[right + k]) {
                k++;
            }
            //todo 还没弄懂为什么可以跳出
            if (right + k >= charArray.length) {
                break;
            }
            if (charArray[right + k] > charArray[left + k]) {
                left = right;
            }
            right++;
        }
        return s.substring(left);
    }
}
