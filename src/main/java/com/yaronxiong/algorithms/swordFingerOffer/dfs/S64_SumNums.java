package com.yaronxiong.algorithms.swordFingerOffer.dfs;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出:6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出:45
 * <p>
 * 限制：
 * <p>
 * 1 <= n<= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/qiu-12n-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S64_SumNums {

    public int sumNums(int n) {
        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        S64_SumNums s64SumNums = new S64_SumNums();
        int nums = s64SumNums.sumNums(100);
        System.out.println(nums);
    }
}
