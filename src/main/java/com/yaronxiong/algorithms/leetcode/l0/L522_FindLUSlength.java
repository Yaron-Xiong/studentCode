package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 522. 最长特殊序列 II
 * 算术评级: 6
 * 中等
 * 相关标签
 * 相关企业
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 * <p>
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * <p>
 * s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * <p>
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 * <p>
 * 示例 1：
 * <p>
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 * <p>
 * 提示:
 * <p>
 * 2 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] 只包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-uncommon-subsequence-ii/description/?envType=daily-question&envId=2024-06-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L522_FindLUSlength {
    public static void main(String[] args) {
        L522_FindLUSlength l522FindLUSlength = new L522_FindLUSlength();
        System.out.println(l522FindLUSlength.findLUSlength(new String[]{"aabbcc", "aabbcc", "bc", "bcc", "aabbccc"}));
    }

    public int findLUSlength(String[] strs) {
        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            String subStr = strs[i];
            boolean check = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                String targetStr = strs[j];
                if (check2(subStr, targetStr)) {
                    check = false;
                }
            }
            if (check) {
                ans = Math.max(ans, subStr.length());
            }
        }
        return ans;
    }

    private boolean check2(String a, String b) {
        int aIndex = 0;
        char[] array = b.toCharArray();
        for (int i = 0; i < array.length && aIndex < a.length(); i++) {
            if (a.charAt(aIndex) == b.charAt(i)) {
                aIndex++;
            }
        }
        return aIndex == a.length();
    }
}
