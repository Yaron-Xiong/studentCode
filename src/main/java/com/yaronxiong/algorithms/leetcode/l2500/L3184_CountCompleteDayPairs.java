package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 3184. 构成整天的下标对数目 I
 * 算术评级: 1
 * 第 402 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1150
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
 * <p>
 * 整天 定义为时间持续时间是 24 小时的 整数倍 。
 * <p>
 * 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
 * <p>
 * 示例 1：
 * <p>
 * 输入： hours = [12,12,30,24,24]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 构成整天的下标对分别是 (0, 1) 和 (3, 4)。
 * <p>
 * 示例 2：
 * <p>
 * 输入： hours = [72,48,24,3]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。
 * <p>
 * 提示：
 * <p>
 * 1 <= hours.length <= 100
 * 1 <= hours[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-i/description/?envType=daily-question&envId=2024-10-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3184_CountCompleteDayPairs {
    public static void main(String[] args) {
        L3184_CountCompleteDayPairs l3184CountCompleteDayPairs = new L3184_CountCompleteDayPairs();
        System.out.println(l3184CountCompleteDayPairs.countCompleteDayPairs(new int[]{72, 48, 24, 3}));
    }

    public int countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int hour : hours) {
            int curH = hour % 24;
            int target = (24 - curH) % 24;
            Integer cnt = map.getOrDefault(target, 0);
            ans += cnt;
            map.merge(curH, 1, Integer::sum);
        }
        return ans;
    }
}
