package com.accompnay.TopicAlgorithms.leetcode.l0;

/**
 * 307. 区域和检索 - 数组可修改
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个数组 nums ，请你完成两类查询。
 * <p>
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 调用 update 和 sumRange 方法次数不大于 3 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/range-sum-query-mutable/description/?envType=daily-question&envId=2023-11-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L307_NumArray {
    public static void main(String[] args) {
        L307_NumArray.NumArray l307NumArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(l307NumArray.sumRange(0, 2));
        l307NumArray.update(1, 2);
        System.out.println(l307NumArray.sumRange(0, 2));
    }

    static class NumArray {
        private int[] tree;

        private int lowBit(int x) {
            return x & (-x);
        }

        private void add(int index, int val) {
            if (index >= this.tree.length) {
                return;
            }
            //修改parent值
            this.tree[index] += val;
            add(index + lowBit(index), val);
        }

        private int query(int index) {
            if (index <= 0) {
                return 0;
            }
            return this.tree[index] + query(index - lowBit(index));
        }

        private int[] nums;

        public NumArray(int[] nums) {
            this.tree = new int[nums.length + 1];
            this.nums = nums;
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            this.nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);
        }
    }
}
