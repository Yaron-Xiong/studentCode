package com.yaronxiong.algorithms.practiceSet.random_num;

import java.util.*;

/**
 * 710. 黑名单中的随机数
 * 困难
 * 215
 * 相关企业
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。
 * 任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * 输出
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * <p>
 * 解释
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
 * // 0、1、4和6的返回概率必须相等(即概率为1/4)。
 * solution.pick(); // 返回 4
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 6
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 0
 * solution.pick(); // 返回 4
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 109
 * 0 <= blacklist.length <= min(105, n - 1)
 * 0 <= blacklist[i] < n
 * blacklist 中所有值都 不同
 * pick 最多被调用 2 * 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/random-pick-with-blacklist/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
	private Random random;
	private Map<Integer, Integer> map;
	private int bound = 0;

	public Solution(int n, int[] blacklist) {
		map = new HashMap<>();
		random = new Random();
		bound = n - blacklist.length;
		for (int i : blacklist) {
			map.put(i, 666);
		}
		int lastIndex = n - 1;
		for (int i : blacklist) {
			if (i >= bound) {
				continue;
			}
			while (map.containsKey(lastIndex)) {
				lastIndex--;
			}
			map.put(i, lastIndex--);
		}
	}

	public int pick() {
		int i = random.nextInt(bound);
		return map.getOrDefault(i, i);
	}
	public static void main(String[] args) {

		Solution solution = new Solution(3, new int[]{0});
		System.out.println(solution.pick());
		System.out.println(solution.pick());
		System.out.println(solution.pick());
	}

}
