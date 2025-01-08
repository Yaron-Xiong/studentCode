package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2264. 字符串中最大的 3 位相同数字
 * 算术评级: 2
 * 第 292 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1309
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
 * <p>
 * 该整数是 num 的一个长度为 3 的 子字符串 。
 * 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * num 或优质整数中可能存在 前导零 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "6777133339"
 * 输出："777"
 * 解释：num 中存在两个优质整数："777" 和 "333" 。
 * "777" 是最大的那个，所以返回 "777" 。
 * 示例 2：
 * <p>
 * 输入：num = "2300019"
 * 输出："000"
 * 解释："000" 是唯一一个优质整数。
 * 示例 3：
 * <p>
 * 输入：num = "42352338"
 * 输出：""
 * 解释：不存在长度为 3 且仅由一个唯一数字组成的整数。因此，不存在优质整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= num.length <= 1000
 * num 仅由数字（0 - 9）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/largest-3-same-digit-number-in-string/description/?envType=daily-question&envId=2025-01-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2264_LargestGoodInteger {
    public static void main(String[] args) {
        L2264_LargestGoodInteger l2264LargestGoodInteger = new L2264_LargestGoodInteger();
        System.out.println(l2264LargestGoodInteger.largestGoodInteger("6777133339"));
    }

    public String largestGoodInteger(String num) {
        char[] charArray = num.toCharArray();
        String ans = "";
        for (int index = 0; index < charArray.length; index++) {
            int len = 1;
            for (; index + 1 < charArray.length && charArray[index + 1] == charArray[index]; index++) {
                len++;
            }
            if (len < 3) {
                continue;
            }
            //此时找到了一个答案
            String tempAns = num.substring(index - 2, index + 1);
            if (ans.compareTo(tempAns) < 0) {
                ans = tempAns;
            }
        }
        return ans;
    }
}
