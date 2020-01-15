package com.accompnay.swordFingerOffer;

/**
 * @author Accompany
 * Date:2020/1/14
 * 斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * 斐波那契数列 = f(n-1)+f(n-2);
 *
 * 实现方式1：
 * 递归 时间复杂度 n^2
 *
 * 实现方式2：
 * 自低向上，维护一个缓存，负责保存每次的计算结果  时间复杂度 n 空间复杂度 n
 *
 * 实现方式3
 * 自顶向下，在递归的基础上完成 时间复杂度 n 空间复杂度 n
 *
 */
public class Demo7 {
    /*
    递归计算
    public int Fibonacci(int n) {
        if (n<=1){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }*/

    /*
    自低向上，先计算子模块
    public int Fibonacci(int n) {
        if (n<=1){
            return n;
        }
        return num(n);
    }

    public int num(int n){
        int [] cache = new int[n+1];
        cache[1] = 1;
        int num = 0;
        for (int i = 2; i <= n; i++) {
            num = cache[i-1] + cache[i-2];
            cache[i]= num;
        }
        return num;
    }*/

    //如果使用int 则会出现初始值0,但是如何使用Integer初始值会为null

    private Integer [] cache = new Integer [40];
    public int Fibonacci(int n) {
        if (n<=1){
            return n;
        }
        cache[0] = 0;
        cache[1] = 1;
        return num(n);
    }
    public int num(int n){
        if (cache[n]!=null){
            return cache[n];
        }
        return num(n-1)+num(n-2);
    }
    public static void main(String[] args) {
        Demo7 demo = new Demo7();
        int i = demo.Fibonacci(4);
        System.out.println(i);
    }
}
