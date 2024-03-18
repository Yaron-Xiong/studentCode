package com.yaronxiong.algorithms.swordFingerOffer.divideAndConquer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * <p>
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * <p>
 * -100.0 <x< 100.0
 * -231<= n <=231-1
 * -104<= xn<= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S16_MyPow {

    public double myPow(double x, int n) {
        if (n < 0) {
            double x1 = 1 / x;
            return myPow(x1, -n - 1) * x1;
        }
        if (n == 0) {
            return 1;
        }
        //切割n
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        S16_MyPow s16MyPow = new S16_MyPow();
        double pow = s16MyPow.myPow(2, -2147483648);
        System.out.println(pow);
    }
}
