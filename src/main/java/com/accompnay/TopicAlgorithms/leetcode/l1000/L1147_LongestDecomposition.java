package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1147. 段式回文
 * 提示
 * 困难
 * 72
 * 相关企业
 * 你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:
 * <p>
 * subtexti 是 非空 字符串
 * 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
 * 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
 * 返回k可能最大值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ghiabcdefhelloadamhelloabcdefghi"
 * 输出：7
 * 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
 * 示例 2：
 * <p>
 * 输入：text = "merchant"
 * 输出：1
 * 解释：我们可以把字符串拆分成 "(merchant)"。
 * 示例 3：
 * <p>
 * 输入：text = "antaprezatepzapreanta"
 * 输出：11
 * 解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1147_LongestDecomposition {
	public static void main(String[] args) {
		L1147_LongestDecomposition l1147LongestDecomposition = new L1147_LongestDecomposition();
		System.out.println(l1147LongestDecomposition.longestDecomposition("merchant"));
	}

	public int longestDecomposition(String text) {
		return dfs(text, 0, text.length(), 1);
	}

	private int dfs(String text, int left, int right, int matchSize) {
		if (left >= right) {
			return 0;
		}
		if (left + matchSize > right - matchSize) {
			return 1;
		}
		//判断 left + matchSize & length-1 - left -match 是否一致
		String t1 = text.substring(left, left + matchSize);
		String t2 = text.substring(right - matchSize, right);
		int v1 = 0;
		int v2 = 0;
		if (t1.equals(t2)) {
			//选择当前节点
			//System.out.println(t1);
			v1 = dfs(text, left + matchSize, right - matchSize, 1) + 2;
		}else {
			//不选择当前节点
			v2 = dfs(text, left, right, matchSize + 1);
		}
		return Math.max(v1, v2);
	}
}
