package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1012. 至少有 1 位重复的数字
 * 提示
 * 困难
 * 249
 * 相关企业
 * 给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 20
 * 输出：1
 * 解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：10
 * 解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
 * 示例 3：
 * <p>
 * 输入：n = 1000
 * 输出：262
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1012_NumDupDigitsAtMostN {
	public static void main(String[] args) {
		L1012_NumDupDigitsAtMostN l1012NumDupDigitsAtMostN = new L1012_NumDupDigitsAtMostN();
		System.out.println(l1012NumDupDigitsAtMostN.numDupDigitsAtMostN(252));
	}

	private char[] chars;
	private int[][] memo;

	public int numDupDigitsAtMostN(int n) {
		chars = String.valueOf(n).toCharArray();
		memo = new int[chars.length][1 << 10];
		for (int[] ints : memo) {
			Arrays.fill(ints, -1);
		}
		return n - dfs(0, 0, false, true);
	}

	private int dfs(int i, int mask, boolean isNum, boolean isLimit) {
		if (i >= chars.length) {
			return isNum ? 1 : 0;
		}
		if (!isLimit && isNum && memo[i][mask] != -1) {
			return memo[i][mask];
		}
		int res = 0;
		//当前位空出来 相当于 1000 -> 999
		if (!isNum) {
			res = dfs(i + 1, mask, false, false);
		}
		int up = isLimit ? chars[i] - '0' : 9;
		for (int curNum = isNum ? 0 : 1; curNum <= up; curNum++) {
			if ((mask >> curNum & 1) == 1) {
				continue;
			}
			res += dfs(i + 1, 1 << curNum | mask, true, isLimit && curNum == up);
		}
		if (!isLimit && isNum) {
			memo[i][mask] = res;
		}
		return res;
	}
}
