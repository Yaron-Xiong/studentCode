package com.accompnay.TopicAlgorithms.leetcode.l2000;

import javafx.util.Pair;

import java.util.*;

/**
 * 2736. 最大和查询
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个长度为 n 、下标从 0 开始的整数数组 nums1 和 nums2 ，另给你一个下标从 1 开始的二维数组 queries ，其中 queries[i] = [xi, yi] 。
 * <p>
 * 对于第 i 个查询，在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中，
 * 找出 nums1[j] + nums2[j] 的 最大值 ，如果不存在满足条件的 j 则返回 -1 。
 * <p>
 * 返回数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
 * 输出：[6,10,7]
 * 解释：
 * 对于第 1 个查询：xi = 4 且 yi = 1 ，可以选择下标 j = 0 ，此时 nums1[j] >= 4 且 nums2[j] >= 1 。nums1[j] + nums2[j] 等于 6 ，可以证明 6 是可以获得的最大值。
 * 对于第 2 个查询：xi = 1 且 yi = 3 ，可以选择下标 j = 2 ，此时 nums1[j] >= 1 且 nums2[j] >= 3 。nums1[j] + nums2[j] 等于 10 ，可以证明 10 是可以获得的最大值。
 * 对于第 3 个查询：xi = 2 且 yi = 5 ，可以选择下标 j = 3 ，此时 nums1[j] >= 2 且 nums2[j] >= 5 。nums1[j] + nums2[j] 等于 7 ，可以证明 7 是可以获得的最大值。
 * 因此，我们返回 [6,10,7] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
 * 输出：[9,9,9]
 * 解释：对于这个示例，我们可以选择下标 j = 2 ，该下标可以满足每个查询的限制。
 * 示例 3：
 * <p>
 * 输入：nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
 * 输出：[-1]
 * 解释：示例中的查询 xi = 3 且 yi = 3 。对于每个下标 j ，都只满足 nums1[j] < xi 或者 nums2[j] < yi 。因此，不存在答案。
 * <p>
 * 提示：
 * <p>
 * nums1.length == nums2.length
 * n == nums1.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 109
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * xi == queries[i][1]
 * yi == queries[i][2]
 * 1 <= xi, yi <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-sum-queries/description/?envType=daily-question&envId=2023-11-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2736_MaximumSumQueries {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        Pair<Integer, Integer>[] pairs = new Pair[nums1.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair<>(nums1[i], nums2[i]);
        }
        Arrays.sort(pairs, (a, b) -> b.getKey() - a.getKey());
        Integer[] sortIndex = new Integer[queries.length];
        for (int i = 0; i < sortIndex.length; i++) {
            sortIndex[i] = i;
        }
        Arrays.sort(sortIndex, (a, b) -> queries[b][0] - queries[a][0]);
        int[] ans = new int[sortIndex.length];
        int jIndex = 0;
        //y值 & x+y
        List<int[]> deque = new ArrayList<>();
        for (Integer qIndex : sortIndex) {
            int[] query = queries[qIndex];

            int x = query[0];
            int y = query[1];
            for (; jIndex < pairs.length && pairs[jIndex].getKey() >= x; jIndex++) {
                //开始压栈 比较于栈顶的关系
                while (!deque.isEmpty() && deque.get(deque.size() - 1)[1] < pairs[jIndex].getKey() + pairs[jIndex].getValue()) {
                    deque.remove(deque.size() - 1);
                }
                if (deque.isEmpty() || deque.get(deque.size() - 1)[0] < pairs[jIndex].getValue()) {
                    deque.add(new int[]{pairs[jIndex].getValue(), pairs[jIndex].getKey() + pairs[jIndex].getValue()});
                }
            }
            int p = lowerBound(deque, y);
            ans[qIndex] = p < deque.size() ? deque.get(p)[1] : -1;
        }
        return ans;
    }

    // 开区间写法，原理请看 b23.tv/AhwfbS2
    private int lowerBound(List<int[]> st, int target) {
        int left = -1, right = st.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = (left + right) >>> 1;
            if (st.get(mid)[0] >= target) {
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;
    }
}
