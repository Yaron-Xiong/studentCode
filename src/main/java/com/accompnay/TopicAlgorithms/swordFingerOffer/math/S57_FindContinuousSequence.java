package com.accompnay.TopicAlgorithms.swordFingerOffer.math;

import java.util.*;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 简单
 * 相关标签
 * 相关企业
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/description/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S57_FindContinuousSequence {
    public static void main(String[] args) {
        S57_FindContinuousSequence s57FindContinuousSequence = new S57_FindContinuousSequence();
        System.out.println(Arrays.deepToString(s57FindContinuousSequence.findContinuousSequence(9)));
    }

    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;
        int windowsValue = 3;
        List<int[]> ansList = new ArrayList<>();
        while (left < right) {
            if (windowsValue < target) {
                right++;
                windowsValue += right;
            } else if (windowsValue > target) {
                windowsValue -= left;
                left++;
            } else {
                int[] subRes = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    subRes[i - left] = i;
                }
                ansList.add(subRes);
                right++;
                windowsValue += right;
            }
        }
        int[][] res = new int[ansList.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = ansList.get(i);
        }
        return res;
    }

}
