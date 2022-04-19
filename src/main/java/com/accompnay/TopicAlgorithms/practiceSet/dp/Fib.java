package com.accompnay.TopicAlgorithms.practiceSet.dp;

/**
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fib {
	public static void main(String[] args) {
		Fib fib = new Fib();
		int fib1 = fib.fib(4);
		System.out.println(fib1);
	}
	public int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int n_2 = 0;
		int n_1 = 1;
		int curN = 2;
		while (curN < n) {
			curN++;
			int temp = n_1 + n_2;
			n_2 = n_1;
			n_1 = temp;
		}
		return n_1 + n_2;
	}
}
