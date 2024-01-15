package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 中等
 * 1.4K
 * 相关企业
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/3sum-closest/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L16_ThreeSumClosest {
    public static void main(String[] args) {
        L16_ThreeSumClosest l16ThreeSumClosest = new L16_ThreeSumClosest();
        System.out.println(l16ThreeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int temp = nums[i];
            int subTarget = nums[i] + nums[i + 1] + nums[i + 2];
            if (subTarget > target) {
                if (diff > subTarget - target) {
                    diff = subTarget - target;
                    res = subTarget;
                }
                break;
            }

            subTarget = nums[i] + nums[nums.length - 2] + nums[nums.length - 1];
            if (subTarget < target) {
                if (diff > target - subTarget) {
                    diff = target - subTarget;
                    res = subTarget;
                }
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                subTarget = temp + nums[left] + nums[right];
                if (target == subTarget) {
                    return target;
                } else if (subTarget > target) {
                    right--;
                } else {
                    left++;
                }
                int subDiff = Math.abs(subTarget - target);
                if (diff > subDiff) {
                    diff = subDiff;
                    res = subTarget;
                }
            }
        }
        return res;
    }

}
