package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 1330. 翻转子数组得到最大的数组值
 * 提示
 * 困难
 * 88
 * 相关企业
 * 给你一个整数数组 nums 。「数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。
 * <p>
 * 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。
 * <p>
 * 请你找到可行的最大 数组值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,5,4]
 * 输出：10
 * 解释：通过翻转子数组 [3,1,5] ，数组变成 [2,5,1,3,4] ，数组值为 10 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,9,24,2,1,10]
 * 输出：68
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3*10^4
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1330_MaxValueAfterReverse {
    public static void main(String[] args) {
        L1330_MaxValueAfterReverse l1330MaxValueAfterReverse = new L1330_MaxValueAfterReverse();
        System.out.println(l1330MaxValueAfterReverse.maxValueAfterReverse(new int[]{2, 3, 1, 5, 4}));
    }

    public int maxValueAfterReverse(int[] nums) {
        //先对 sum( abs(i,i+1)) 求和
        int sum = 0;
        //划分区间 每次起码得翻转两个
        int res = sum;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //每次将i~j 翻转
                if (i - 1 >= 0) {
                    sum -= (Math.abs(nums[i - 1] - nums[i]));
                    sum += (Math.abs(nums[i - 1] - nums[j]));
                }
                if (j + 1 < nums.length) {
                    sum -= (Math.abs(nums[j] - nums[j + 1]));
                    sum += (Math.abs(nums[i] - nums[j + 1]));
                }
                res = Math.max(sum, res);
                //还原
                if (i - 1 >= 0) {
                    sum += (Math.abs(nums[i - 1] - nums[i]));
                    sum -= (Math.abs(nums[i - 1] - nums[j]));
                }
                if (j + 1 < nums.length) {
                    sum += (Math.abs(nums[j] - nums[j + 1]));
                    sum -= (Math.abs(nums[i] - nums[j + 1]));
                }
            }
        }
        return res;
    }
}
