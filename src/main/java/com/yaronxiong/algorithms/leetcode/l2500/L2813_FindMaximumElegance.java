package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2813. 子序列最大优雅度
 * 算术评级: 8
 * 第 357 场周赛
 * Q4
 * 2582
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的二维整数数组 items 和一个整数 k 。
 * <p>
 * items[i] = [profiti, categoryi]，其中 profiti 和 categoryi 分别表示第 i 个项目的利润和类别。
 * <p>
 * 现定义 items 的 子序列 的 优雅度 可以用 total_profit + distinct_categories2 计算，
 * 其中 total_profit 是子序列中所有项目的利润总和，distinct_categories 是所选子序列所含的所有类别中不同类别的数量。
 * <p>
 * 你的任务是从 items 所有长度为 k 的子序列中，找出 最大优雅度 。
 * <p>
 * 用整数形式表示并返回 items 中所有长度恰好为 k 的子序列的最大优雅度。
 * <p>
 * 注意：数组的子序列是经由原数组删除一些元素（可能不删除）而产生的新数组，且删除不改变其余元素相对顺序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：items = [[3,2],[5,1],[10,1]], k = 2
 * 输出：17
 * 解释：
 * 在这个例子中，我们需要选出长度为 2 的子序列。
 * 其中一种方案是 items[0] = [3,2] 和 items[2] = [10,1] 。
 * 子序列的总利润为 3 + 10 = 13 ，子序列包含 2 种不同类别 [2,1] 。
 * 因此，优雅度为 13 + 22 = 17 ，可以证明 17 是可以获得的最大优雅度。
 * 示例 2：
 * <p>
 * 输入：items = [[3,1],[3,1],[2,2],[5,3]], k = 3
 * 输出：19
 * 解释：
 * 在这个例子中，我们需要选出长度为 3 的子序列。
 * 其中一种方案是 items[0] = [3,1] ，items[2] = [2,2] 和 items[3] = [5,3] 。
 * 子序列的总利润为 3 + 2 + 5 = 10 ，子序列包含 3 种不同类别 [1, 2, 3] 。
 * 因此，优雅度为 10 + 32 = 19 ，可以证明 19 是可以获得的最大优雅度。
 * 示例 3：
 * <p>
 * 输入：items = [[1,1],[2,1],[3,1]], k = 3
 * 输出：7
 * 解释：
 * 在这个例子中，我们需要选出长度为 3 的子序列。
 * 我们需要选中所有项目。
 * 子序列的总利润为 1 + 2 + 3 = 6，子序列包含 1 种不同类别 [1] 。
 * 因此，最大优雅度为 6 + 12 = 7 。
 * <p>
 * 提示：
 * <p>
 * 1 <= items.length == n <= 105
 * items[i].length == 2
 * items[i][0] == profiti
 * items[i][1] == categoryi
 * 1 <= profiti <= 109
 * 1 <= categoryi <= n
 * 1 <= k <= n
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-elegance-of-a-k-length-subsequence/description/?envType=daily-question&envId=2024-06-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2813_FindMaximumElegance {
    public static void main(String[] args) {
        L2813_FindMaximumElegance l2813FindMaximumElegance = new L2813_FindMaximumElegance();
        System.out.println(l2813FindMaximumElegance.findMaximumElegance(new int[][]{{3, 2}, {5, 1}, {10, 1}}, 2));
    }

    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> -Integer.compare(a[0], b[0]));
        long ans = 0;
        long totalProfit = 0;
        Set<Integer> visit = new HashSet<>();
        Deque<Integer> dupDeque = new LinkedList<>();
        for (int i = 0; i < items.length; i++) {
            int[] item = items[i];
            int profit = item[0];
            int category = item[1];
            if (i < k) {
                totalProfit += profit;
                if (!visit.add(category)) {
                    dupDeque.addLast(profit);
                }
            } else if (visit.contains(category) || dupDeque.isEmpty()) {
                continue;
            } else {
                //要移除存在重复组中最小的那个元素
                visit.add(category);
                totalProfit = totalProfit - dupDeque.pollLast() + profit;
            }
            ans = Math.max(ans, totalProfit + ((long) visit.size() * visit.size()));
        }
        return ans;
    }


}
