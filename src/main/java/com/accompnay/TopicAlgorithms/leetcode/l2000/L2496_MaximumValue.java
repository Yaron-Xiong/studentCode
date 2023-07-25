package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2496. 数组中字符串的最大值
 * 提示
 * 简单
 * 31
 * 相关企业
 * 一个由字母和数字组成的字符串的 值 定义如下：
 * <p>
 * 如果字符串 只 包含数字，那么值为该字符串在 10 进制下的所表示的数字。
 * 否则，值为字符串的 长度 。
 * 给你一个字符串数组 strs ，每个字符串都只由字母和数字组成，请你返回 strs 中字符串的 最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["alic3","bob","3","4","00000"]
 * 输出：5
 * 解释：
 * - "alic3" 包含字母和数字，所以值为长度 5 。
 * - "bob" 只包含字母，所以值为长度 3 。
 * - "3" 只包含数字，所以值为 3 。
 * - "4" 只包含数字，所以值为 4 。
 * - "00000" 只包含数字，所以值为 0 。
 * 所以最大的值为 5 ，是字符串 "alic3" 的值。
 * 示例 2：
 * <p>
 * 输入：strs = ["1","01","001","0001"]
 * 输出：1
 * 解释：
 * 数组中所有字符串的值都是 1 ，所以我们返回 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 9
 * strs[i] 只包含小写英文字母和数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2496_MaximumValue {
    public int maximumValue(String[] strs) {
        int res = 0;
        for (String str : strs) {
            try {
                res = Math.max(res, Integer.parseInt(str));
            } catch (NumberFormatException numberFormatException) {
                res = Math.max(res, str.length());
            }
        }
        return res;
    }
}
