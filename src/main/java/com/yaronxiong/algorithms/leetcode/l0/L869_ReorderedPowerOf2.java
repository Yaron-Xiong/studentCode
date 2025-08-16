package com.yaronxiong.algorithms.leetcode.l0;

import java.util.HashSet;
import java.util.Set;

/**
 * 869. 重新排序得到 2 的幂
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reordered-power-of-2/description/?envType=daily-question&envId=2025-08-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L869_ReorderedPowerOf2 {
    public static void main(String[] args) {
        L869_ReorderedPowerOf2 l869ReorderedPowerOf2 = new L869_ReorderedPowerOf2();
        System.out.println(l869ReorderedPowerOf2.reorderedPowerOf2(46));
        System.out.println(l869ReorderedPowerOf2.reorderedPowerOf2(10));
        System.out.println(l869ReorderedPowerOf2.reorderedPowerOf2(2401));
    }
    public boolean reorderedPowerOf2(int n) {
        int[] origin = getArr(n);
        //判断N是否能够构成set里面的数据
        long i1 = 1000000000000L;
        for (long i = 1; i <= i1; i *= 2) {
            int[] arr = getArr(i);
            if (equals(arr, origin)) {
                return true;
            }
        }
        return false;
    }

    private boolean equals(int[] arr1, int[] arr2) {
        if (arr2.length!=arr1.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getArr(long n) {
        int[] arr = new int[10];
        long curN = n;
        while (curN > 0) {
            arr[(int) (curN % 10)]++;
            curN /= 10;
        }
        return arr;
    }
}
