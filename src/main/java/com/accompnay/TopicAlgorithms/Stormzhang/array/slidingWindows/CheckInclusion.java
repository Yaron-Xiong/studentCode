package com.accompnay.TopicAlgorithms.Stormzhang.array.slidingWindows;

/**
 * 567. 字符串的排列：https://leetcode-cn.com/problems/permutation-in-string/
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
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
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckInclusion {
	public static void main(String[] args) {
		CheckInclusion checkInclusion = new CheckInclusion();
		boolean b = checkInclusion.checkInclusion("ab", "bcab");
		System.out.println(b);
	}

	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}
		int[] originArr = new int[26];
		for (char c : s1.toCharArray()) {
			originArr[c - 'a']++;
		}
		int left = 0;
		int right = 0;
		while (right < s2.length()) {
			char c = s2.charAt(right++);
			int i = c - 'a';
			originArr[i]--;
			//控制窗口大小的方式
			//当存在如果使用字符超过了规定数量，则向左指针向右移动 直到合法
			while (originArr[i] < 0) {
				int i1 = s2.charAt(left++) - 'a';
				originArr[i1]++;
			}
			if (right - left == s1.length()) {
				return true;
			}
		}
		return false;
	}
}

