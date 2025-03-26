package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2708. 一个小组的最大实力值
 * 算术评级: 4
 * 第 105 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1502
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。
 * 老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，
 * 那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik] 。
 * <p>
 * 请你返回老师创建的小组能得到的最大实力值为多少。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,-1,-5,2,5,-9]
 * 输出：1350
 * 解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这是可以得到的最大实力值。
 * 示例 2：
 * <p>
 * 输入：nums = [-4,-5,-4]
 * 输出：20
 * 解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 13
 * -9 <= nums[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-strength-of-a-group/description/?envType=daily-question&envId=2024-09-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2708_MaxStrength {
    public static void main(String[] args) {
        L2708_MaxStrength l2708MaxStrength = new L2708_MaxStrength();
        System.out.println(l2708MaxStrength.maxStrength(new int[]{2, 2, 7, 0, -4, 9, 4}));
    }

    public long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        boolean zero = false;
        for (int num : nums) {
            if (num > 0) {
                plus.add(num);
            } else if (num < 0) {
                minus.add(num);
            } else {
                zero = true;
            }
        }
        if (!plus.isEmpty() && !minus.isEmpty()) {
            return getPlusValue(plus) * getMinusSum(minus);
        } else if (!plus.isEmpty()) {
            return getPlusValue(plus);
        } else if (minus.size() >= 2) {
            //有两种可能，存在两个负数，与存在0
            return getMinusSum(minus);
        } else if (zero) {
            return 0;
        }
        return -1;
    }

    private long getMinusSum(List<Integer> minus) {
        long minusSum = 1;
        minus.sort(Integer::compare);
        for (int i = 0; i + 1 < minus.size(); i += 2) {
            long temp = (long) minus.get(i) * minus.get(i + 1);
            minusSum *= temp;
        }
        return minusSum;
    }

    private long getPlusValue(List<Integer> plus) {
        long plusSum = 1;
        for (Integer i : plus) {
            plusSum *= i;
        }
        return plusSum;
    }

}
