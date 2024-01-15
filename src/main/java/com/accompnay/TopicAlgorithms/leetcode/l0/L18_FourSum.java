package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.*;

/**
 * 18. 四数之和
 * 中等
 * 1.7K
 * 相关企业
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/4sum/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L18_FourSum {
    public static void main(String[] args) {
        L18_FourSum l18FourSum = new L18_FourSum();
        System.out.println(l18FourSum.fourSum(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //从四数之和 降级为 三数 再降级为两数
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            long v1 = nums[i];
            if (v1 + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (v1 + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }
            if ((i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                long v2 = nums[j];
                if (v1 + v2 + nums[j + 1] + nums[i + 2] > target) {
                    break;
                }
                if (v1 + v2 + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }
                if ((j > i + 1 && nums[j] == nums[j - 1])) {
                    continue;
                }
                for (int z = j + 1; z < nums.length - 1; z++) {
                    if ((z > j + 1 && nums[z] == nums[z - 1])) {
                        continue;
                    }
                    long v3 = v1 + v2 + nums[z];
                    //找到 target - v1 - v2 - v3 是否存在
                    int v = find(nums, target - v3, z + 1, nums.length);
                    if (v == -1) {
                        continue;
                    }
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[z]);
                    list.add(nums[v]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private int find(int[] nums, long target, int left, int right) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
