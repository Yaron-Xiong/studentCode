package com.accompnay.TopicAlgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6355. 质数减法运算
 * 提示
 * 中等
 * 9
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums ，数组长度为 n 。
 * <p>
 * 你可以执行无限次下述运算：
 * <p>
 * 选择一个之前未选过的下标 i ，并选择一个 严格小于 nums[i] 的质数 p ，从 nums[i] 中减去 p 。
 * 如果你能通过上述运算使得 nums 成为严格递增数组，则返回 true ；否则返回 false 。
 * <p>
 * 严格递增数组 中的每个元素都严格大于其前面的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,9,6,10]
 * 输出：true
 * 解释：
 * 在第一次运算中：选择 i = 0 和 p = 3 ，然后从 nums[0] 减去 3 ，nums 变为 [1,9,6,10] 。
 * 在第二次运算中：选择 i = 1 和 p = 7 ，然后从 nums[1] 减去 7 ，nums 变为 [1,2,6,10] 。
 * 第二次运算后，nums 按严格递增顺序排序，因此答案为 true 。
 * 示例 2：
 * <p>
 * 输入：nums = [6,8,11,12]
 * 输出：true
 * 解释：nums 从一开始就按严格递增顺序排序，因此不需要执行任何运算。
 * 示例 3：
 * <p>
 * 输入：nums = [5,8,3]
 * 输出：false
 * 解释：可以证明，执行运算无法使 nums 按严格递增顺序排序，因此答案是 false 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * nums.length == n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/prime-subtraction-operation/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L6355_PrimeSubOperation {
	public static void main(String[] args) {
		L6355_PrimeSubOperation l6355PrimeSubOperation = new L6355_PrimeSubOperation();
		System.out.println(l6355PrimeSubOperation.primeSubOperation(new int[]{3, 4, 10, 15, 6}));
	}

	public boolean primeSubOperation(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int num = nums[nums.length - 1];
		for (int i : nums) {
			num = Math.max(i, num);
		}
		list.add(2);
		for (int i = 3; i <= num; i += 2) {
			boolean flag = true;
			int jM = (int) Math.sqrt(i);
			for (int j = 3; j <= jM; j += 2) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				list.add(i);
			}
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i + 1] > nums[i]) {
				continue;
			}
			boolean flag = false;
			for (Integer p : list) {
				if (p < nums[i] && nums[i] - p < nums[i + 1]) {
					nums[i] = nums[i] - p;
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}
}
