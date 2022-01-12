package com.accompnay.TopicAlgorithms.Stormzhang.array.doublePointer;

/**
 * 283. 移动零:https://leetcode-cn.com/problems/move-zeroes
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {
	public static void main(String[] args) {
		MoveZeroes moveZeroes = new MoveZeroes();
		moveZeroes.moveZeroes(new int[]{});
	}

	/**
	 * 如果使用 slow = 0 fast = length -1 不能保证稳定性 ，因为每次都与最后一位进行交换
	 * 如果使用 slow = 0 fast = 0 能保证稳定性，相当于冒泡过程
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		int slow = 0;
		int fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != 0) {
				swap(nums, slow, fast);
				slow++;
			}
			fast++;
		}
	}

	private void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
}
