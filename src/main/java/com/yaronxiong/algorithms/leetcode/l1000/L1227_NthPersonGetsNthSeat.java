package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1227. 飞机座位分配概率
 * 算术评级: 6
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
 * <p>
 * 剩下的乘客将会：
 * <p>
 * 如果他们自己的座位还空着，就坐到自己的座位上，
 * <p>
 * 当他们自己的座位被占用时，随机选择其他座位
 * 第 n 位乘客坐在自己的座位上的概率是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1.00000
 * 解释：第一个人只会坐在自己的位置上。
 * 示例 2：
 * <p>
 * 输入: n = 2
 * 输出: 0.50000
 * 解释：在第一个人选好座位坐下后，第二个人坐在自己的座位上的概率是 0.5。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/airplane-seat-assignment-probability/description/?envType=daily-question&envId=2024-10-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1227_NthPersonGetsNthSeat {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }
}
