package com.accompnay.TopicAlgorithms.practiceSet.list.slidingwindows;

import java.util.HashMap;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckInclusion {
	public static void main(String[] args) {
		CheckInclusion checkInclusion = new CheckInclusion();
		boolean b = checkInclusion.checkInclusion("ab", "eidboaoo");
		System.out.println(b);
	}

	public boolean checkInclusion(String s1, String s2) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] chars = s1.toCharArray();
		for (char aChar : chars) {
			map.put(aChar, map.getOrDefault(aChar, 0) + 1);
		}
		int left = 0;
		int right = 0;
		int valid = map.size();
		while (right < s2.length()) {
			char rightChar = s2.charAt(right);
			right++;
			if (map.containsKey(rightChar)) {
				map.put(rightChar, map.get(rightChar) - 1);
				if (map.get(rightChar) == 0) {
					valid--;
				}
			}
			if (valid == 0) {
				return true;
			}

			while (right - left >= s1.length()) {
				//缩小left
				char leftChar = s2.charAt(left);
				if (map.containsKey(leftChar)) {
					if (map.get(leftChar) == 0) {
						valid++;
					}
					map.put(leftChar, map.get(leftChar) + 1);
				}
				left++;
			}
		}
		return false;
	}
}
