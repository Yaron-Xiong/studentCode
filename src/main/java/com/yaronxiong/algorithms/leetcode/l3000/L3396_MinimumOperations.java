package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3396. 使数组元素互不相同所需的最少操作次数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，你需要确保数组中的元素 互不相同 。为此，你可以执行以下操作任意次：
 * <p>
 * 从数组的开头移除 3 个元素。如果数组中元素少于 3 个，则移除所有剩余元素。
 * 注意：空数组也视作为数组元素互不相同。返回使数组元素互不相同所需的 最少操作次数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3,4,2,3,3,5,7]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 第一次操作：移除前 3 个元素，数组变为 [4, 2, 3, 3, 5, 7]。
 * 第二次操作：再次移除前 3 个元素，数组变为 [3, 5, 7]，此时数组中的元素互不相同。
 * 因此，答案是 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [4,5,6,4,4]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 第一次操作：移除前 3 个元素，数组变为 [4, 4]。
 * 第二次操作：移除所有剩余元素，数组变为空。
 * 因此，答案是 2。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [6,7,8,9]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组中的元素已经互不相同，因此不需要进行任何操作，答案是 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3396_MinimumOperations {
    public static void main(String[] args) {
        L3396_MinimumOperations l3396MinimumOperations = new L3396_MinimumOperations();
        System.out.println(l3396MinimumOperations.minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
    }

    public int minimumOperations(int[] nums) {
        boolean[] visited = new boolean[101];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (visited[nums[i]]) {
                //说明从这里开始都不满足了要删除！！
                int len = i + 1;
                if (len % 3 == 0) {
                    return len / 3;
                }
                return (len / 3) + 1;
            }
            visited[nums[i]] = true;
        }
        return 0;
    }
}
