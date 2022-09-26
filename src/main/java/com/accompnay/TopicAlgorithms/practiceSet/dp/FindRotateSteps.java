package com.accompnay.TopicAlgorithms.practiceSet.dp;

import java.util.*;

/**
 * 514. 自由之路
 * 电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * <p>
 * 您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 * 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 * 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 * 当然, 我们还需要1步进行拼写。
 * 因此最终的输出是 4。
 * 示例 2:
 * <p>
 * 输入: ring = "godding", key = "godding"
 * 输出: 13
 * <p>
 * 提示：
 * <p>
 * 1 <= ring.length, key.length <= 100
 * ring 和 key 只包含小写英文字母
 * 保证 字符串 key 一定可以由字符串  ring 旋转拼出
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/freedom-trail
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRotateSteps {
	public static void main(String[] args) {
		FindRotateSteps findRotateSteps = new FindRotateSteps();
		int rotateSteps = findRotateSteps.findRotateSteps("godding", "gd");
		System.out.println(rotateSteps);
	}

	public int findRotateSteps(String ring, String key) {
		Map<Character, List<Integer>> indexMap = new HashMap<>(ring.length());
		char[] chars = ring.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			List<Integer> list = indexMap.computeIfAbsent(chars[i], (k) -> new ArrayList<>());
			list.add(i);
		}

		return dp(indexMap, ring, key, 0, 0);
	}

	private Map<Integer, Integer> memo = new HashMap<>();

	private int dp(Map<Character, List<Integer>> indexMap, String ring, String key, int rIndex, int kIndex) {
		if (kIndex >= key.length()) {
			return 0;
		}
		int memoKey = rIndex * 1000 + kIndex;
		if (memo.containsKey(memoKey)) {
			return memo.get(memoKey);
		}
		int res = Integer.MAX_VALUE;
		for (Integer index : indexMap.get(key.charAt(kIndex))) {
			//当前位置与目标位置index的差距值
			int delta = Math.abs(rIndex - index);
			//选择是顺时针还是逆时针转动
			int min = Math.min(ring.length() - delta, delta);
			int tempRes = dp(indexMap, ring, key, index, kIndex + 1) + min + 1;
			res = Math.min(res, tempRes);
		}
		memo.put(memoKey, res);
		return res;
	}
}
