package com.yaronxiong.algorithms.practiceSet.list;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {
	public static void main(String[] args) {
		MoveZeroes moveZeroes = new MoveZeroes();
		moveZeroes.moveZeroes(new int[]{0, 1, 0, 3, 12});
	}

	public void moveZeroes(int[] nums) {
		int index = 0;
		int collationIndex = -1;
		while (index < nums.length) {
			if (nums[index] != 0) {
				swap(nums, index, ++collationIndex);
			}
			index++;
		}
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
