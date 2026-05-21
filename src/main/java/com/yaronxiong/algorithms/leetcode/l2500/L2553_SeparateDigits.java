package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2553. 分割数组中数字的数位
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数数组 nums ，请你返回一个数组 answer ，你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案数组中。
 * <p>
 * 对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。
 * <p>
 * 比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [13,25,83,77]
 * 输出：[1,3,2,5,8,3,7,7]
 * 解释：
 * - 分割 13 得到 [1,3] 。
 * - 分割 25 得到 [2,5] 。
 * - 分割 83 得到 [8,3] 。
 * - 分割 77 得到 [7,7] 。
 * answer = [1,3,2,5,8,3,7,7] 。answer 中的数字分割结果按照原数字在数组中的相同顺序排列。
 * 示例 2：
 * <p>
 * 输入：nums = [7,1,3,9]
 * 输出：[7,1,3,9]
 * 解释：nums 中每个整数的分割是它自己。
 * answer = [7,1,3,9] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/separate-the-digits-in-an-array/description/?envType=daily-question&envId=2026-05-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2553_SeparateDigits {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            List<Integer> list = new ArrayList<>();
            while (num > 0) {
                list.add(num % 10);
                num /= 10;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                ans.add(list.get(i));
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
