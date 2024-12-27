package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 3185. 构成整天的下标对数目 II
 * 算术评级: 3
 * 第 402 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1385
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，
 * 表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
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
 * 1 <= hours.length <= 5 * 105
 * 1 <= hours[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii/description/?envType=daily-question&envId=2024-10-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3185_CountCompleteDayPairs {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Long> map = new HashMap<>();
        long ans = 0;
        for (int hour : hours) {
            int curH = hour % 24;
            int target = (24 - curH) % 24;
            long cnt = map.getOrDefault(target, 0L);
            ans += cnt;
            map.merge(curH, 1L, Long::sum);
        }
        return ans;
    }
}
