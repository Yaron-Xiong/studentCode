package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 2427. 公因子的数目
 * 提示
 * 简单
 * 48
 * 相关企业
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * <p>
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 12, b = 6
 * 输出：4
 * 解释：12 和 6 的公因子是 1、2、3、6 。
 * 示例 2：
 * <p>
 * 输入：a = 25, b = 30
 * 输出：2
 * 解释：25 和 30 的公因子是 1、5 。
 * <p>
 * 提示：
 * <p>
 * 1 <= a, b <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-common-factors/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2427_CommonFactors {
	public static void main(String[] args) {
		L2427_CommonFactors l2427CommonFactors = new L2427_CommonFactors();
		System.out.println(l2427CommonFactors.commonFactors(12, 6));
	}
	public int commonFactors(int a, int b) {
		int maxI = Math.max(a, b);
		int res = 0;
		for (int i = 1; i <= maxI; i++) {
			if (a % i == 0 && b % i == 0) {
				res++;
			}
		}
		return res;
	}
}
