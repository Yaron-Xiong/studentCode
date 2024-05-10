package com.yaronxiong.algorithms.leetcode.lm;

import java.util.*;

/**
 * 面试题 17.05. 字母与数字
 * 提示
 * 中等
 * 156
 * 相关企业
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * <p>
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 * <p>
 * 输入: ["A","A"]
 * <p>
 * 输出: []
 * 提示：
 * <p>
 * array.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-longest-subarray-lcci/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LM1705_FindLongestSubarray {

	public static void main(String[] args) {
		LM1705_FindLongestSubarray lm1705FindLongestSubarray = new LM1705_FindLongestSubarray();
		String[] longestSubarray = lm1705FindLongestSubarray.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
		System.out.println(Arrays.toString(longestSubarray));
	}


	public String[] findLongestSubarray(String[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		int dp = (array[0].toCharArray()[0] >> 6 & 1) * 2 - 1;
		map.put(dp, 0);
		int size = 0;
		int sIndex = -1;
		for (int i = 1; i < array.length; i++) {
			dp = dp + ((array[i].toCharArray()[0] >> 6 & 1) * 2 - 1);
			if (dp == 0) {
				sIndex = 0;
				size = i + 1;
			} else if (map.containsKey(dp)) {
				int preIndex = map.get(dp) + 1;
				int curSize = i - preIndex + 1;
				if (curSize > size) {
					size = curSize;
					sIndex = preIndex;
				}
			}
			if (!map.containsKey(dp)) {
				map.put(dp, i);
			}
		}
		if (sIndex == -1) {
			return new String[]{};
		}
		String[] res = new String[size];
		System.arraycopy(array, sIndex, res, 0, size);
		return res;
	}
}
