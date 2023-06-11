package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 2423. 删除字符使频率相同
 * 提示
 * 简单
 * 70
 * 相关企业
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
 * <p>
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * <p>
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abcc"
 * 输出：true
 * 解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
 * 示例 2：
 * <p>
 * 输入：word = "aazz"
 * 输出：false
 * 解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。
 * 所以不可能让剩余所有字母出现频率相同。
 * <p>
 * 提示：
 * <p>
 * 2 <= word.length <= 100
 * word 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/remove-letter-to-equalize-frequency/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2423_EqualFrequency {
	public static void main(String[] args) {
		L2423_EqualFrequency l2423EqualFrequency = new L2423_EqualFrequency();
		System.out.println(l2423EqualFrequency.equalFrequency("aazz"));
	}

	public boolean equalFrequency(String word) {
		int[] chars = new int[26];
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			chars[index]++;
		}
		//模拟删除
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 0) {
				continue;
			}
			//假设删除chars[i]
			chars[i]--;
			if (isSame(chars)) {
				return true;
			}
			chars[i]++;
		}
		return false;
	}

	public boolean isSame(int[] chars) {
		int t = -1;
		for (int times : chars) {
			if (times == 0) {
				continue;
			}
			if (t == -1) {
				t = times;
			}
			if (t != times) {
				return false;
			}
		}
		return true;
	}
}
