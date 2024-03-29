package com.yaronxiong.algorithms.swordFingerOffer.math;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 简单
 * 相关标签
 * 相关企业
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/description/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S62_LastRemaining {
    public static void main(String[] args) {
        S62_LastRemaining s62LastRemaining = new S62_LastRemaining();
        System.out.println(s62LastRemaining.lastRemaining(10, 17));
    }

    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int previousLevelIndex = lastRemaining(n - 1, m);
        return (previousLevelIndex + m) % n;
    }
}
