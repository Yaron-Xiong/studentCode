package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/valid-triangle-number/description/?envType=daily-question&envId=2025-09-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L611_TriangleNumber {
    public static void main(String[] args) {
        L611_TriangleNumber l611TriangleNumber = new L611_TriangleNumber();
        System.out.println(l611TriangleNumber.triangleNumber(new int[]{2, 2, 3, 5}));
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //c < a+b
                int target = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                ans += left - j - 1;
            }
        }
        return ans;
    }

}
