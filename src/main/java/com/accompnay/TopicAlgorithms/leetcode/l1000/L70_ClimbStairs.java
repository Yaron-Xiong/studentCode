package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 70. 爬楼梯
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/climbing-stairs/description/?envType=daily-question&envId=2023-12-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L70_ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int n_1 = 1;
        int n_2 = 2;
        int curN = 3;
        while (curN < n) {
            int temp = n_1 + n_2;
            n_1 = n_2;
            n_2 = temp;
            curN++;
        }
        return n_1 + n_2;
    }
}
