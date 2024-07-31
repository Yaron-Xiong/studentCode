package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3072. 将元素分配到两个数组中 II
 * 算术评级: 10
 * 第 387 场周赛
 * Q4
 * 2053
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
 * <p>
 * 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。
 * <p>
 * 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。
 * 在第一次操作中，将 nums[1] 追加到 arr1 。
 * 在第二次操作中，将 nums[2] 追加到 arr2 。
 * 之后，在第 i 次操作中：
 * <p>
 * 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
 * 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
 * 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
 * 如果仍然相等，那么将 nums[i] 追加到 arr1 。
 * 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
 * <p>
 * 返回整数数组 result 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,3]
 * 输出：[2,3,1,3]
 * 解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
 * 在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
 * 在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
 * 在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
 * 因此，连接形成的数组 result 是 [2,3,1,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,14,3,1,2]
 * 输出：[5,3,1,2,14]
 * 解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
 * 在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
 * 在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
 * 在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
 * 在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
 * 因此，连接形成的数组 result 是 [5,3,1,2,14] 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,3,3,3]
 * 输出：[3,3,3,3]
 * 解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
 * 因此，连接形成的数组 result 是 [3,3,3,3] 。
 * <p>
 * 提示：
 * <p>
 * 3 <= n <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/description/?envType=daily-question&envId=2024-06-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3072_ResultArray {

    public static void main(String[] args) {
        L3072_ResultArray l3072ResultArray = new L3072_ResultArray();
        System.out.println(Arrays.toString(l3072ResultArray.resultArray(new int[]{2, 1, 3, 3})));
    }

    public static class FenwickTree {
        private int[] arr;

        public FenwickTree(int length) {
            this.arr = new int[length];
        }

        public void add(int i) {
            while (i < arr.length) {
                arr[i]++;
                i += lowbit(i);
            }
        }

        public int get(int i) {
            int ans = 0;
            while (i > 0) {
                ans += arr[i];
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & (~i + 1);
        }

    }

    public int[] resultArray(int[] nums) {
        int[] cloneNums = nums.clone();
        Arrays.sort(cloneNums);
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        a1.add(nums[0]);
        a2.add(nums[1]);

        FenwickTree f1 = new FenwickTree(nums.length + 1);
        FenwickTree f2 = new FenwickTree(nums.length + 1);
        f1.add(Arrays.binarySearch(cloneNums, nums[0]) + 1);
        f2.add(Arrays.binarySearch(cloneNums, nums[1]) + 1);

        for (int i = 2; i < nums.length; i++) {
            int itemIndex = Arrays.binarySearch(cloneNums, nums[i]);
            int v1 = a1.size() - f1.get(itemIndex + 1);
            int v2 = a2.size() - f2.get(itemIndex + 1);
            if (v1 > v2) {
                f1.add(itemIndex + 1);
                a1.add(nums[i]);
            } else if (v1 < v2) {
                f2.add(itemIndex + 1);
                a2.add(nums[i]);
            } else if (a1.size() <= a2.size()) {
                f1.add(itemIndex + 1);
                a1.add(nums[i]);
            } else {
                f2.add(itemIndex + 1);
                a2.add(nums[i]);
            }
        }
        a1.addAll(a2);

        int[] ans = new int[a1.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = a1.get(i);
        }
        return ans;
    }

}
