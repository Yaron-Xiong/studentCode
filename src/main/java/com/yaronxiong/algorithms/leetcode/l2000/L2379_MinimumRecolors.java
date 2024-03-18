package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 * 提示
 * 简单
 * 44
 * 相关企业
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * <p>
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * <p>
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * <p>
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocks = "WBBWWBBWBW", k = 7
 * 输出：3
 * 解释：
 * 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
 * 得到 blocks = "BBBBBBBWBW" 。
 * 可以证明无法用少于 3 次操作得到 7 个连续的黑块。
 * 所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：blocks = "WBWBBBW", k = 2
 * 输出：0
 * 解释：
 * 不需要任何操作，因为已经有 2 个连续的黑块。
 * 所以我们返回 0 。
 * <p>
 * 提示：
 * <p>
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W' ，要么是 'B' 。
 * 1 <= k <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2379_MinimumRecolors {
	public static void main(String[] args) {
		L2379_MinimumRecolors l2379MinimumRecolors = new L2379_MinimumRecolors();
		System.out.println(l2379MinimumRecolors.minimumRecolors("WBBWWBBWBW", 7));
	}

	public int minimumRecolors(String blocks, int k) {
		int curModifyCount = 0;
		for (int i = 0; i < blocks.toCharArray().length && i < k; i ++) {
			if (blocks.charAt(i) != 'B') {
				curModifyCount++;
			}
		}
		int minModifyCount = curModifyCount;
		for (int i = k; i < blocks.toCharArray().length; i++) {
			if (blocks.charAt(i - k) != 'B') {
				curModifyCount--;
			}
			if (blocks.charAt(i) != 'B') {
				curModifyCount++;
			}
			minModifyCount = Math.min(curModifyCount, minModifyCount);
		}
		return minModifyCount;
	}
}

