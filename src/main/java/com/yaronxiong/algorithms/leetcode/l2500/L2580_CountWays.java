package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2580. 统计将重叠区间合并成组的方案数
 * 第 99 场双周赛
 * Q3
 * 1632
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整数都包含在第 i 个区间中。
 * <p>
 * 你需要将 ranges 分成 两个 组（可以为空），满足：
 * <p>
 * 每个区间只属于一个组。
 * 两个有 交集 的区间必须在 同一个 组内。
 * 如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
 * <p>
 * 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
 * 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranges = [[6,10],[5,15]]
 * 输出：2
 * 解释：
 * 两个区间有交集，所以它们必须在同一个组内。
 * 所以有两种方案：
 * - 将两个区间都放在第 1 个组中。
 * - 将两个区间都放在第 2 个组中。
 * 示例 2：
 * <p>
 * 输入：ranges = [[1,3],[10,20],[2,5],[4,8]]
 * 输出：4
 * 解释：
 * 区间 [1,3] 和 [2,5] 有交集，所以它们必须在同一个组中。
 * 同理，区间 [2,5] 和 [4,8] 也有交集，所以它们也必须在同一个组中。
 * 所以总共有 4 种分组方案：
 * - 所有区间都在第 1 组。
 * - 所有区间都在第 2 组。
 * - 区间 [1,3] ，[2,5] 和 [4,8] 在第 1 个组中，[10,20] 在第 2 个组中。
 * - 区间 [1,3] ，[2,5] 和 [4,8] 在第 2 个组中，[10,20] 在第 1 个组中。
 * <p>
 * 提示：
 * <p>
 * 1 <= ranges.length <= 105
 * ranges[i].length == 2
 * 0 <= starti <= endi <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/?envType=daily-question&envId=2024-03-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2580_CountWays {
    public static void main(String[] args) {
        L2580_CountWays l2580CountWays = new L2580_CountWays();
        System.out.println(l2580CountWays.countWays(new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}}));
    }

    public int countWays(int[][] ranges) {
        //将由交集的区间先合并，合并后再分隔
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int index = 0;
        long ans = 1;
        long MOD = (long) 1e9 + 7;
        while (index < ranges.length) {
            int right = ranges[index][1];
            while (index + 1 < ranges.length && (right >= ranges[index + 1][0])) {
                right = Math.max(right, ranges[index + 1][1]);
                index++;
            }
            ans = (ans * 2) % MOD;
            index++;
        }
        return (int) ans;
    }
}
