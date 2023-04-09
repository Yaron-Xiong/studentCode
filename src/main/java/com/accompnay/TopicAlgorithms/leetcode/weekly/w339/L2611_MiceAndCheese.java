package com.accompnay.TopicAlgorithms.leetcode.weekly.w339;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2611. 老鼠和奶酪
 * 提示
 * 中等
 * 9
 * 相关企业
 * 有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
 * <p>
 * 下标为 i 处的奶酪被吃掉的得分为：
 * <p>
 * 如果第一只老鼠吃掉，则得分为 reward1[i] 。
 * 如果第二只老鼠吃掉，则得分为 reward2[i] 。
 * 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
 * <p>
 * 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
 * <p>
 * 示例 1：
 * <p>
 * 输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
 * 输出：15
 * 解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
 * 总得分为 4 + 4 + 3 + 4 = 15 。
 * 15 是最高得分。
 * 示例 2：
 * <p>
 * 输入：reward1 = [1,1], reward2 = [1,1], k = 2
 * 输出：2
 * 解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
 * 总得分为 1 + 1 = 2 。
 * 2 是最高得分。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == reward1.length == reward2.length <= 105
 * 1 <= reward1[i], reward2[i] <= 1000
 * 0 <= k <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/mice-and-cheese/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2611_MiceAndCheese {
	public static void main(String[] args) {
		L2611_MiceAndCheese l2611MiceAndCheese = new L2611_MiceAndCheese();
		System.out.println(l2611MiceAndCheese.miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
	}


	public int miceAndCheese(int[] reward1, int[] reward2, int k) {
		Integer[] newReward = new Integer[reward1.length];
		Integer[] sortArr = new Integer[newReward.length];
		for (int i = 0; i < newReward.length; i++) {
			newReward[i] = reward1[i] - reward2[i];
			sortArr[i] = i;
		}
		Arrays.sort(sortArr, (a, b) -> -Integer.compare(newReward[a], newReward[b]));
		Set<Integer> set = new HashSet<>();
		int res = 0;
		for (int i = 0; i < k; i++) {
			res += reward1[sortArr[i]];
			set.add(sortArr[i]);
		}
		for (int i = 0; i < reward2.length; i++) {
			if (set.contains(i)) {
				continue;
			}
			res += reward2[i];
		}
		return res;
	}

}
