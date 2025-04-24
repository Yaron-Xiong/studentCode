package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 1399. 统计最大组的数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * <p>
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：4
 * 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
 * [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：总共有 2 个大小为 1 的组 [1]，[2]。
 * 示例 3：
 * <p>
 * 输入：n = 15
 * 输出：6
 * 示例 4：
 * <p>
 * 输入：n = 24
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-largest-group/?envType=daily-question&envId=2025-04-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1399_CountLargestGroup {
    public static void main(String[] args) {
        L1399_CountLargestGroup l1399CountLargestGroup = new L1399_CountLargestGroup();
        int countLargestGroup = l1399CountLargestGroup.countLargestGroup(15);
        System.out.println(countLargestGroup);
    }
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int v = i;
            int temp = 0;
            while (v != 0) {
                temp += v % 10;
                v /= 10;
            }
            map.merge(temp, 1, Integer::sum);
        }
        int maxSize = 0;
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxSize) {
                maxSize = entry.getValue();
                maxCnt = 1;
            } else if (entry.getValue() == maxSize) {
                maxCnt++;
            }
        }
        return maxCnt;

    }
}
