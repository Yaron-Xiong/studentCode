package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3653. 区间乘法查询后的异或 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 和一个大小为 q 的二维整数数组 queries，其中 queries[i] = [li, ri, ki, vi]。
 * <p>
 * 对于每个查询，按以下步骤执行操作：
 * <p>
 * 设定 idx = li。
 * 当 idx <= ri 时：
 * 更新：nums[idx] = (nums[idx] * vi) % (109 + 7)
 * 将 idx += ki。
 * 在处理完所有查询后，返回数组 nums 中所有元素的 按位异或 结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,1,1], queries = [[0,2,1,4]]
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 唯一的查询 [0, 2, 1, 4] 将下标 0 到下标 2 的每个元素乘以 4。
 * 数组从 [1, 1, 1] 变为 [4, 4, 4]。
 * 所有元素的异或为 4 ^ 4 ^ 4 = 4。
 * 示例 2：
 * <p>
 * 输入： nums = [2,3,1,5,4], queries = [[1,4,2,3],[0,2,1,2]]
 * <p>
 * 输出： 31
 * <p>
 * 解释：
 * <p>
 * 第一个查询 [1, 4, 2, 3] 将下标 1 和 3 的元素乘以 3，数组变为 [2, 9, 1, 15, 4]。
 * 第二个查询 [0, 2, 1, 2] 将下标 0、1 和 2 的元素乘以 2，数组变为 [4, 18, 2, 15, 4]。
 * 所有元素的异或为 4 ^ 18 ^ 2 ^ 15 ^ 4 = 31。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 103
 * 1 <= nums[i] <= 109
 * 1 <= q == queries.length <= 103
 * queries[i] = [li, ri, ki, vi]
 * 0 <= li <= ri < n
 * 1 <= ki <= n
 * 1 <= vi <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/xor-after-range-multiplication-queries-i/description/?envType=daily-question&envId=2026-04-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3653_XorAfterQueries {
    public static void main(String[] args) {
        L3653_XorAfterQueries l3653XorAfterQueries = new L3653_XorAfterQueries();
        System.out.println(l3653XorAfterQueries.xorAfterQueries(new int[]{780}, new int[][]{{0,0,1,13},{0,0,1,17},{0,0,1,9},{0,0,1,18},{0,0,1,16},{0,0,1,6},{0,0,1,4},{0,0,1,11},{0,0,1,7},{0,0,1,18},{0,0,1,8},{0,0,1,15},{0,0,1,12}}));
        System.out.println(l3653XorAfterQueries.xorAfterQueries(new int[]{1, 1, 1}, new int[][]{{0, 2, 1, 4}}));
        System.out.println(l3653XorAfterQueries.xorAfterQueries(new int[]{2, 3, 1, 5, 4}, new int[][]{{1, 4, 2, 3}, {0, 2, 1, 2}}));
    }
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int idx = query[0];
            int value = query[3];
            while (idx <= query[1]) {
                long temp = (long) nums[idx] * value;
                nums[idx] = (int) (temp % mod);
                idx += query[2];
            }
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            ans ^= num;
        }
        return ans;
    }
}
