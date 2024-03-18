package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2651. 计算列车到站时间
 * 提示
 * 简单
 * 29
 * 相关企业
 * 给你一个正整数 arrivalTime 表示列车正点到站的时间（单位：小时），另给你一个正整数 delayedTime 表示列车延误的小时数。
 * <p>
 * 返回列车实际到站的时间。
 * <p>
 * 注意，该问题中的时间采用 24 小时制。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arrivalTime = 15, delayedTime = 5
 * 输出：20
 * 解释：列车正点到站时间是 15:00 ，延误 5 小时，所以列车实际到站的时间是 15 + 5 = 20（20:00）。
 * 示例 2：
 * <p>
 * 输入：arrivalTime = 13, delayedTime = 11
 * 输出：0
 * 解释：列车正点到站时间是 13:00 ，延误 11 小时，所以列车实际到站的时间是 13 + 11 = 24（在 24 小时制中表示为 00:00 ，所以返回 0）。
 * <p>
 * 提示：
 * <p>
 * 1 <= arrivaltime < 24
 * 1 <= delayedTime <= 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/calculate-delayed-arrival-time/?envType=daily-question&envId=2023-09-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2651_FindDelayedArrivalTime {
    public static void main(String[] args) {
        L2651_FindDelayedArrivalTime l2651FindDelayedArrivalTime = new L2651_FindDelayedArrivalTime();
        System.out.println(l2651FindDelayedArrivalTime.findDelayedArrivalTime(13, 11));
    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
