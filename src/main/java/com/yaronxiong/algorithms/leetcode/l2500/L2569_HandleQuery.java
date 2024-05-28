package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2569. 更新数组后处理求和查询
 * 提示
 * 困难
 * 27
 * 相关企业
 * 给你两个下标从 0 开始的数组 nums1 和 nums2 ，和一个二维数组 queries 表示一些操作。总共有 3 种类型的操作：
 * <p>
 * 操作类型 1 为 queries[i] = [1, l, r] 。你需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成 0 。l 和 r 下标都从 0 开始。
 * 操作类型 2 为 queries[i] = [2, p, 0] 。对于 0 <= i < n 中的所有下标，令 nums2[i] = nums2[i] + nums1[i] * p 。
 * 操作类型 3 为 queries[i] = [3, 0, 0] 。求 nums2 中所有元素的和。
 * 请你返回一个数组，包含所有第三种操作类型的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,0,1], nums2 = [0,0,0], queries = [[1,1,1],[2,1,0],[3,0,0]]
 * 输出：[3]
 * 解释：第一个操作后 nums1 变为 [1,1,1] 。第二个操作后，nums2 变成 [1,1,1] ，所以第三个操作的答案为 3 。所以返回 [3] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], nums2 = [5], queries = [[2,0,0],[3,0,0]]
 * 输出：[5]
 * 解释：第一个操作后，nums2 保持不变为 [5] ，所以第二个操作的答案是 5 。所以返回 [5] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length,nums2.length <= 105
 * nums1.length = nums2.length
 * 1 <= queries.length <= 105
 * queries[i].length = 3
 * 0 <= l <= r <= nums1.length - 1
 * 0 <= p <= 106
 * 0 <= nums1[i] <= 1
 * 0 <= nums2[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/handling-sum-queries-after-update/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2569_HandleQuery {
    public static void main(String[] args) {
        L2569_HandleQuery l2569HandleQuery = new L2569_HandleQuery();
        long[] longs = l2569HandleQuery.handleQuery(new int[]{1, 0, 1}, new int[]{0, 0, 0}, new int[][]{{1, 1, 1}, {2, 1, 0}, {3, 0, 0}});
        System.out.println(Arrays.toString(longs));
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> resList = new ArrayList<>();
        long nums2Sum = 0;
        for (int item : nums2) {
            nums2Sum += item;
        }
        long oneTotal = 0;
        for (int j : nums1) {
            oneTotal += j == 1 ? 1 : 0;
        }
        for (int[] query : queries) {
            if (query[0] == 1) {
                //修改某个区间内 1的个数
                for (int index = query[1]; index <= query[2]; index++) {
                    if (nums1[index] == 0) {
                        oneTotal++;
                        nums1[index] = 1;
                    } else {
                        oneTotal--;
                        nums1[index] = 0;
                    }
                }
            } else if (query[0] == 2) {
                //合并 num1 & nums2
                nums2Sum += oneTotal * query[1];
            } else {
                //求和
                resList.add(nums2Sum);
            }
        }
        long[] res = new long[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
