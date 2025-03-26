package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashSet;
import java.util.Set;

/**
 * 2829. k-avoiding 数组的最小总和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数 n 和 k 。
 * <p>
 * 对于一个由 不同 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 k-avoiding 数组。
 * <p>
 * 返回长度为 n 的 k-avoiding 数组的可能的最小总和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, k = 4
 * 输出：18
 * 解释：设若 k-avoiding 数组为 [1,2,4,5,6] ，其元素总和为 18 。
 * 可以证明不存在总和小于 18 的 k-avoiding 数组。
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 6
 * 输出：3
 * 解释：可以构造数组 [1,2] ，其元素总和为 3 。
 * 可以证明不存在总和小于 3 的 k-avoiding 数组。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/determine-the-minimum-sum-of-a-k-avoiding-array/?envType=daily-question&envId=2025-03-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2829_MinimumSum {
    public static void main(String[] args) {
        L2829_MinimumSum l2829MinimumSum = new L2829_MinimumSum();
        System.out.println(l2829MinimumSum.minimumSum(2, 6));
    }

    public int minimumSum(int n, int k) {
        //每选出一个数字另外一个数字就不能选择了
        Set<Integer> bankSet = new HashSet<>();
        int curNum = 1;
        int sum = 0;
        while (n > 0) {
            while (bankSet.contains(curNum)) {
                curNum++;
            }
            if (curNum <k){
                bankSet.add(k - curNum);
            }
            sum += curNum;
            curNum++;
            n--;
        }
        return sum;
    }
}
