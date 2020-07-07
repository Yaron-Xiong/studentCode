package com.accompnay.algorithmCombat.resursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Accompany
 * LeetCode 50 Pow(x,n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 只递归了一棵树的深度
 * 时间复杂度：O(logn)
 * 空间复杂度：logn
 */
public class Demo1 {
    /*private Map<Integer,Double> cache = new HashMap<>();
    public double myPow(double x, int n) {
        if (n==1){
            return x;
        }else if (n==-1){
            return (double) 1/x;
        }else if (n==0){
            return 1;
        }
        //分治
        double a = 0;
        double b = 0;
        if (cache.get(n/2)!=null){
            a = cache.get(n/2);
        }else {
            a = myPow(x,n/2);
            cache.put(n/2,a);
        }
        b = n%2==0?a:n>0?a*x:a*(1/x);
        return a*b;
    }*/

    public double myPow(double x, int n) {
        long N = n;
        if (N<0){
            x = 1/x;
            N = -N;
        }else if (N==0){
            return 1;
        }
        return fastPow(x,N);
    }

    public double fastPow(double x,long n){
        if (n==1){
            return x;
        }
        //分治
        double a = fastPow(x,n/2);
        double b = n%2==0?a:a*x;
        return a*b;
    }
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        System.out.println(demo1.myPow(2,-2147483648));
    }
}
