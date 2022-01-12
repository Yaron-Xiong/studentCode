package com.accompnay.TopicAlgorithms.swordFingerOffer.dynamic;

/**
 * @author Accompany
 * Date:2020/1/14
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 与Demo7(斐波那契数列)相似，可以缓存结果
 * <p>
 * 解决方案1：
 * 暴力递归  时间复杂度 n^2
 * 解决方案2：
 * 记忆化递归
 *
 * 剑指offer-10：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class NumWays {

	public int numWays(int n) {
	    if (n==0){
	        return 1;
        }
		if (n == 1 || n == 2) {
			return n;
		}
		int n_1 = 2;
		int n_2 = 1;
		int result = n_1 + n_2;
		for (int i = 3; i < n; i++) {
			n_2 = n_1;
			n_1 = result;
			result = (n_1 + n_2) % 1000000007;
		}
		return result;
	}

	public static void main(String[] args) {
		NumWays numWays = new NumWays();
		int i = numWays.numWays(7);
		System.out.println(i);
	}

}
