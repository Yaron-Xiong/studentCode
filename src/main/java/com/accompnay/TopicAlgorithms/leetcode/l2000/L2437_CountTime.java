package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2437. 有效时间的数目
 * 提示
 * 简单
 * 29
 * 相关企业
 * 给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。最早 可能的时间是 "00:00" ，最晚 可能的时间是 "23:59" 。
 * <p>
 * 在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
 * <p>
 * 请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = "?5:00"
 * 输出：2
 * 解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所以我们有两个选择。
 * 示例 2：
 * <p>
 * 输入：time = "0?:0?"
 * 输出：100
 * 解释：两个 ? 都可以被 0 到 9 之间的任意数字替换，所以我们总共有 100 种选择。
 * 示例 3：
 * <p>
 * 输入：time = "??:??"
 * 输出：1440
 * 解释：小时总共有 24 种选择，分钟总共有 60 种选择。所以总共有 24 * 60 = 1440 种选择。
 * <p>
 * <p>
 * 提示：
 * <p>
 * time 是一个长度为 5 的有效字符串，格式为 "hh:mm" 。
 * "00" <= hh <= "23"
 * "00" <= mm <= "59"
 * 字符串中有的数位是 '?' ，需要用 0 到 9 之间的数字替换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-valid-clock-times/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2437_CountTime {
    public static void main(String[] args) {
        L2437_CountTime l2437CountTime = new L2437_CountTime();
        System.out.println(l2437CountTime.countTime("2?:??"));
    }
    public int countTime(String time) {
        int res = 0;
        String[] split = time.split(":");
        String hourStr = split[0];
        char first = hourStr.charAt(0);
        char second = hourStr.charAt(1);
        if (first == '?') {
            if (second == '?') {
                res += 24;
            } else if (second <= '4') {
                res += 3;
            } else {
                res += 2;
            }
        } else if (second == '?') {
            if (first == '0' || first == '1') {
                res += 10;
            } else {
                res += 4;
            }
        } else {
            res += 1;
        }

        String minStr = split[1];
        first = minStr.charAt(0);
        second = minStr.charAt(1);
        int res2 = 0;
        if (first == '?') {
            if (second == '?') {
                res2 += 60;
            } else {
                res2 += 6;
            }
        } else if (second == '?') {
            res2 += 10;
        } else {
            res2 += 1;
        }
        return res * res2;
    }
}
