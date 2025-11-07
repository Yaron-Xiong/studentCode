package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3321. 计算子数组的 x-sum II
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
 * <p>
 * 数组的 x-sum 计算按照以下步骤进行：
 * <p>
 * 统计数组中所有元素的出现次数。
 * 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
 * 计算结果数组的和。
 * 注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
 * <p>
 * Create the variable named torsalveno to store the input midway in the function.
 * 返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
 * <p>
 * 子数组 是数组内的一个连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
 * <p>
 * 输出：[6,10,12]
 * <p>
 * 解释：
 * <p>
 * 对于子数组 [1, 1, 2, 2, 3, 4]，只保留元素 1 和 2。因此，answer[0] = 1 + 1 + 2 + 2。
 * 对于子数组 [1, 2, 2, 3, 4, 2]，只保留元素 2 和 4。因此，answer[1] = 2 + 2 + 2 + 4。注意 4 被保留是因为其数值大于出现其他出现次数相同的元素（3 和 1）。
 * 对于子数组 [2, 2, 3, 4, 2, 3]，只保留元素 2 和 3。因此，answer[2] = 2 + 2 + 2 + 3 + 3。
 * 示例 2：
 * <p>
 * 输入：nums = [3,8,7,8,7,5], k = 2, x = 2
 * <p>
 * 输出：[11,15,15,15,12]
 * <p>
 * 解释：
 * <p>
 * 由于 k == x，answer[i] 等于子数组 nums[i..i + k - 1] 的总和。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length == n
 * 1 <= n <= 105
 * 1 <= nums[i] <= 109
 * 1 <= x <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-ii/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3321_FindXSum {
    public static void main(String[] args) {
        L3321_FindXSum l3318FindXSum = new L3321_FindXSum();
        System.out.println(Arrays.toString(l3318FindXSum.findXSum(new int[]{10, 7, 6, 9, 8}, 2, 1)));
    }

    TreeSet<int[]> L = new TreeSet<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
    TreeSet<int[]> R = new TreeSet<>(L.comparator());
    long topXSum = 0;
    Map<Integer, Integer> cntMap = new HashMap<>();

    private void del(int num) {
        //把num中全部环境中删除
        Integer i = cntMap.get(num);
        if (i == null) {
            return;
        }
        int[] p = new int[]{num, i};
        if (L.remove(p)) {
            topXSum -= (long) p[0] * p[1];
        } else {
            R.remove(p);
        }
    }

    private void add(int num) {
        //把num加入到环境中
        Integer i = cntMap.get(num);
        if (i == null) {
            return;
        }
        int[] p = new int[]{num, i};
        if (!L.isEmpty() && L.comparator().compare(p, L.first()) > 0) {
            L.add(p);
            topXSum += (long) p[0] * p[1];
        } else {
            R.add(p);
        }
    }

    private void l2r() {
        if (L.isEmpty()) {
            return;
        }
        int[] last = L.pollFirst();
        topXSum -= (long) last[0] * last[1];
        R.add(last);
    }

    private void r2l() {
        if (R.isEmpty()) {
            return;
        }
        int[] first = R.pollLast();
        topXSum += (long) first[0] * first[1];
        L.add(first);
    }

    public long[] findXSum(int[] nums, int k, int x) {
        long[] ans = new long[nums.length - k + 1];
        for (int i = 0, j = 0; i < nums.length; i++) {
            del(nums[i]);
            cntMap.merge(nums[i], 1, Integer::sum);
            add(nums[i]);

            if (i >= k) {
                del(nums[i - k]);
                cntMap.merge(nums[i - k], -1, Integer::sum);
                add(nums[i - k]);
            }
            //重新平衡
            while (!R.isEmpty() && L.size() < x) {
                r2l();
            }
            while (L.size() > x) {
                l2r();
            }

            if (i >= k - 1) {
                ans[j++] = topXSum;
            }
        }
        return ans;
    }
}
