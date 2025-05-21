package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3355. 零数组变换 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri]。
 * <p>
 * 对于每个查询 queries[i]：
 * <p>
 * 在 nums 的下标范围 [li, ri] 内选择一个下标 子集。
 * 将选中的每个下标对应的元素值减 1。
 * 零数组 是指所有元素都等于 0 的数组。
 * <p>
 * 如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,0,1], queries = [[0,2]]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 对于 i = 0：
 * 选择下标子集 [0, 2] 并将这些下标处的值减 1。
 * 数组将变为 [0, 0, 0]，这是一个零数组。
 * 示例 2：
 * <p>
 * 输入： nums = [4,3,2,1], queries = [[1,3],[0,2]]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 对于 i = 0：
 * 选择下标子集 [1, 2, 3] 并将这些下标处的值减 1。
 * 数组将变为 [4, 2, 1, 0]。
 * 对于 i = 1：
 * 选择下标子集 [0, 1, 2] 并将这些下标处的值减 1。
 * 数组将变为 [3, 1, 0, 0]，这不是一个零数组。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= li <= ri < nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/zero-array-transformation-i/description/?envType=daily-question&envId=2025-05-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3355_IsZeroArray {
    public static void main(String[] args) {
        L3355_IsZeroArray l3355IsZeroArray = new L3355_IsZeroArray();
        int[] nums = {7};
        int[][] queries = {{0, 0}};
        boolean zeroArray = l3355IsZeroArray.isZeroArray(nums, queries);
        System.out.println(zeroArray);
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];
        for (int[] query : queries) {
            diff[query[0]] += 1;
            diff[query[1] + 1] -= 1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += diff[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
