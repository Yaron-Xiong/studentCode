package com.accompnay.TopicAlgorithms.practiceSet.dp;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsMatch {
	public static void main(String[] args) {
		IsMatch isMatch = new IsMatch();
		boolean cb = isMatch.isMatch("bbbba", ".*a*a");
		System.out.println(cb);
	}

	public boolean isMatch(String s, String p) {
		return dp(s, 0, p, 0);
	}

	private boolean dp(String s, int i, String p, int j) {
		if (i >= s.length() && hasOver(p, j)) {
			return true;
		} else if (i >= s.length() || j >= p.length()) {
			return false;
		}
		char sChar = s.charAt(i);
		char pChar = p.charAt(j);
		if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
			if (sChar == pChar || pChar == '.') {
				return dp(s, i + 1, p, j) || dp(s, i, p, j + 2);
			} else {
				return dp(s, i, p, j + 2);
			}
		} else {
			if (sChar == pChar || pChar == '.') {
				return dp(s, i + 1, p, j + 1);
			} else {
				return false;
			}
		}
	}

	public boolean hasOver(String s, int index) {
		if (index >= s.length()) {
			return true;
		}
		if ((s.length() - index) % 2 != 0) {
			return false;
		}
		while (index < s.length()) {
			if (s.charAt(index + 1) != '*') {
				return false;
			}
			index += 2;
		}
		return true;
	}
}
