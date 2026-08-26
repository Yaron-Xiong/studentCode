package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashSet;
import java.util.Set;

/**
 * 3718. 缺失的最小倍数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k，请返回从 nums 中缺失的、最小的正整数 k 的倍数。
 * <p>
 * 倍数 指能被 k 整除的任意正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [8,2,3,4,6], k = 2
 * <p>
 * 输出： 10
 * <p>
 * 解释：
 * <p>
 * 当 k = 2 时，其倍数为 2、4、6、8、10、12……，其中在 nums 中缺失的最小倍数是 10。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,4,7,10,15], k = 5
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 当 k = 5 时，其倍数为 5、10、15、20……，其中在 nums 中缺失的最小倍数是 5。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-missing-multiple-of-k/description/?envType=daily-question&envId=2026-08-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3718_MissingMultiple {
    public static void main(String[] args) {
        L3718_MissingMultiple l3718MissingMultiple = new L3718_MissingMultiple();
        System.out.println(l3718MissingMultiple.missingMultiple(new int[]{8, 2, 3, 4, 6}, 2));
    }
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                set.add(nums[i]);
            }
        }
        int cnt = 1;
        while (true) {
            int target = k * cnt;
            if (!set.contains(target)) {
                return target;
            }
            cnt++;
        }
    }
}
