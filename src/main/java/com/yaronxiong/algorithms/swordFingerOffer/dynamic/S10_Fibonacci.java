package com.yaronxiong.algorithms.swordFingerOffer.dynamic;

/**
 * 剑指offer-10
 * 斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * 斐波那契数列 = f(n-1)+f(n-2);
 * <p>
 * 实现方式1：
 * 递归 时间复杂度 n^2
 * <p>
 * 实现方式2：
 * 自低向上，维护一个缓存，负责保存每次的计算结果  时间复杂度 n 空间复杂度 n
 * <p>
 * 实现方式3
 * 自顶向下，在递归的基础上完成 时间复杂度 n 空间复杂度 n
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S10_Fibonacci {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int fn0 = 0;
        int fn1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = fn0 + fn1;
            temp %= 1000000007;
            fn0 = fn1;
            fn1 = temp;
        }
        return fn1;
    }

    public static void main(String[] args) {
        S10_Fibonacci s10Fibonacci = new S10_Fibonacci();
        int fib = s10Fibonacci.fib(45);
        System.out.println(fib);
    }
}
