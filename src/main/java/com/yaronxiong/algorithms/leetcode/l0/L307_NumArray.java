package com.yaronxiong.algorithms.leetcode.l0;

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
        private int[] treeArr;
        private int[] originNum;

        public NumArray(int[] nums) {
            treeArr = new int[nums.length + 1];
            originNum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                update(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            int updateValue = val - originNum[index];
            originNum[index] = val;
            for (int i = index + 1; i < treeArr.length; i += lowbit(i)) {
                treeArr[i] += updateValue;
            }
        }

        public int sumRange(int left, int right) {
            return getValue(right + 1) - getValue(left);
        }

        private int getValue(int treeIndex) {
            int ans = 0;
            for (int i = treeIndex; i > 0; i -= lowbit(i)) {
                ans += treeArr[i];
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & (~i + 1);
        }
    }
}
