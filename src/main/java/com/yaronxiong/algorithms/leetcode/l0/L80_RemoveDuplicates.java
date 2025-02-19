package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 80. 删除有序数组中的重复项 II
 * 已解答
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=daily-question&envId=2025-02-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L80_RemoveDuplicates {
    public static void main(String[] args) {
        L80_RemoveDuplicates l80RemoveDuplicates = new L80_RemoveDuplicates();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(l80RemoveDuplicates.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int writeIndex = 2;
        int readIndex = 2;
        int ans = 2;
        for (; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] == nums[writeIndex - 2]) {
                continue;
            }
            nums[writeIndex] = nums[readIndex];
            writeIndex++;
            ans++;
        }
        return ans;
    }
}
