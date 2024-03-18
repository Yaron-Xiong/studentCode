package com.yaronxiong.algorithms.practiceSet.list;

import java.util.*;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/advantage-shuffle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AdvantageCount {
	public static void main(String[] args) {
		AdvantageCount advantageCount = new AdvantageCount();
		int[] count = advantageCount.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
		System.out.println(Arrays.toString(count));
	}

	public int[] advantageCount(int[] nums1, int[] nums2) {
		Integer[] idx1 = new Integer[nums1.length];
		Integer[] idx2 = new Integer[nums2.length];
		for (int i = 0; i < nums1.length; i++) {
			idx1[i] = i;
			idx2[i] = i;
		}
		Arrays.sort(idx1, Comparator.comparingInt(i -> nums1[i]));
		Arrays.sort(idx2, Comparator.comparingInt(i -> nums2[i]));

		int[] res = new int[nums1.length];
		int index = 0;
		int left = 0;
		int right = nums2.length - 1;
		while (index < nums1.length) {
			if (nums1[idx1[index]] > nums2[idx2[left]]) {
				res[idx2[left]] = nums1[idx1[index]];
				index++;
				left++;
			} else {
				res[idx2[right]] = nums1[idx1[index]];
				index++;
				right--;
			}
		}
		return res;
	}
}
