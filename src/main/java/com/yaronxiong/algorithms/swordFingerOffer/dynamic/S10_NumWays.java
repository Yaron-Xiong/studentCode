package com.yaronxiong.algorithms.swordFingerOffer.dynamic;

/**
 * @author Accompany
 * Date:2020/1/14
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 与Demo7(斐波那契数列)相似，可以缓存结果
 * <p>
 * 解决方案1：
 * 暴力递归  时间复杂度 n^2
 * 解决方案2：
 * 记忆化递归
 * <p>
 * 剑指offer-10：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S10_NumWays {
    public int numWays(int n) {
        if (n <= 2) {
            return n == 0 ? 1 : n;
        }
        int fn0 = 1;
        int fn1 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = fn0 + fn1;
            temp %= 1000000007;
            fn0 = fn1;
            fn1 = temp;
        }
        return fn1;
    }

    public static void main(String[] args) {
        S10_NumWays s10NumWays = new S10_NumWays();
        int i = s10NumWays.numWays(7);
        System.out.println(i);
    }

}
