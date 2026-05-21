package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.HashMap;
import java.util.Map;

/**
 * 1722. 执行交换操作后的最小汉明距离
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数数组 source 和 target ，长度都是 n 。
 * 还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。
 * 注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
 * <p>
 * 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。
 * 形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
 * <p>
 * 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
 * 输出：1
 * 解释：source 可以按下述方式转换：
 * - 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
 * - 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
 * source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
 * 示例 2：
 * <p>
 * 输入：source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
 * 输出：2
 * 解释：不能对 source 执行交换操作。
 * source 和 target 间的汉明距离是 2 ，二者有 2 处元素不同，在下标 1 和下标 2 。
 * 示例 3：
 * <p>
 * 输入：source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * n == source.length == target.length
 * 1 <= n <= 105
 * 1 <= source[i], target[i] <= 105
 * 0 <= allowedSwaps.length <= 105
 * allowedSwaps[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimize-hamming-distance-after-swap-operations/description/?envType=daily-question&envId=2026-04-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1722_MinimumHammingDistance {
    public static void main(String[] args) {
        L1722_MinimumHammingDistance l1722MinimumHammingDistance = new L1722_MinimumHammingDistance();
        System.out.println(l1722MinimumHammingDistance.minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 5}, new int[][]{{0, 1}, {2, 3}}));
        System.out.println(l1722MinimumHammingDistance.minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{1, 3, 2, 4}, new int[][]{}));
        System.out.println(l1722MinimumHammingDistance.minimumHammingDistance(new int[]{5, 1, 2, 4, 3}, new int[]{1, 5, 4, 2, 3}, new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}}));
    }

    private int[] fa;
    private int[] rank;

    private int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rank[x] < rank[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        fa[y] = x;
        if (rank[x] == rank[y]) {
            rank[x]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        fa = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }

        for (int[] pair : allowedSwaps) {
            union(pair[0], pair[1]);
        }

        Map<Integer, Map<Integer, Integer>> sets = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int f = find(i);
            sets.putIfAbsent(f, new HashMap<>());
            Map<Integer, Integer> cnt = sets.get(f);
            cnt.put(source[i], cnt.getOrDefault(source[i], 0) + 1);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int f = find(i);
            Map<Integer, Integer> cnt = sets.get(f);
            if (cnt.getOrDefault(target[i], 0) > 0) {
                cnt.put(target[i], cnt.get(target[i]) - 1);
            } else {
                ans++;
            }
        }
        return ans;
    }
}
