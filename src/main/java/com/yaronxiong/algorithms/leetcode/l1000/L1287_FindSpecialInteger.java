package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1287. 有序数组中出现次数超过25%的元素
 * 算术评级: 3
 * 第 15 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1179
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * <p>
 * 请你找到并返回这个整数
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/description/?envType=daily-question&envId=2025-02-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1287_FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int len = 1;
        double targetLen = (arr.length * 0.25);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                len++;
            } else {
                len = 1;
            }
            if (len >= targetLen) {
                return arr[i];
            }
        }
        return -1;
    }
}
