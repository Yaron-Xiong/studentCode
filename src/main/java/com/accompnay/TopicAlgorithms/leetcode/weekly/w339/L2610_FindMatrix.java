package com.accompnay.TopicAlgorithms.leetcode.weekly.w339;

import java.util.ArrayList;
import java.util.List;

/**
 * 2610. 转换二维数组
 * 提示
 * 中等
 * 7
 * 相关企业
 * 给你一个整数数组 nums 。请你创建一个满足以下条件的二维数组：
 * <p>
 * 二维数组应该 只 包含数组 nums 中的元素。
 * 二维数组中的每一行都包含 不同 的整数。
 * 二维数组的行数应尽可能 少 。
 * 返回结果数组。如果存在多种答案，则返回其中任何一种。
 * <p>
 * 请注意，二维数组的每一行上可以存在不同数量的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,1,2,3,1]
 * 输出：[[1,3,4,2],[1,3],[1]]
 * 解释：根据题目要求可以创建包含以下几行元素的二维数组：
 * - 1,3,4,2
 * - 1,3
 * - 1
 * nums 中的所有元素都有用到，并且每一行都由不同的整数组成，所以这是一个符合题目要求的答案。
 * 可以证明无法创建少于三行且符合题目要求的二维数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[[4,3,2,1]]
 * 解释：nums 中的所有元素都不同，所以我们可以将其全部保存在二维数组中的第一行。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/convert-an-array-into-a-2d-array-with-conditions/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2610_FindMatrix {
	public static void main(String[] args) {
		L2610_FindMatrix l2610FindMatrix = new L2610_FindMatrix();
		System.out.println(l2610FindMatrix.findMatrix(new int[]{1, 2, 3, 4}));
	}

	public List<List<Integer>> findMatrix(int[] nums) {
		List<List<Integer>> heap = new ArrayList<>();
		int[] replace = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			if (replace[nums[i]] >= heap.size()) {
				heap.add(new ArrayList<>());
			}
			List<Integer> list = heap.get(replace[nums[i]]);
			list.add(nums[i]);
			replace[nums[i]]++;
		}
		return heap;
	}

}
