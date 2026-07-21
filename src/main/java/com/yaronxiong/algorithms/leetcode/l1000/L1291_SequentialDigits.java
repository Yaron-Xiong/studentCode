package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. 顺次数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * <p>
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * <p>
 * 示例 1：
 * <p>
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 * <p>
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 * <p>
 * 提示：
 * <p>
 * 10 <= low <= high <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sequential-digits/description/?envType=daily-question&envId=2026-07-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1291_SequentialDigits {
    public static void main(String[] args) {
        L1291_SequentialDigits l1291SequentialDigits = new L1291_SequentialDigits();
        System.out.println(l1291SequentialDigits.sequentialDigits(1000, 13000));
        System.out.println(l1291SequentialDigits.sequentialDigits(100, 300));

    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        //按数字开始遍历
        for (int i = 1; i <= 9; i++) {
            int temp = i;
            for (int j = i; temp <= high && j <= 9; j++) {
                if (temp >= low) {
                    ans.add(temp);
                }
                temp = temp * 10 + j + 1;
            }
        }
        ans.sort(Integer::compareTo);
        return ans;
    }
}
