package com.yaronxiong.algorithms.Stormzhang.tree.bfs;

import java.util.*;

/**
 * 752. 打开转盘锁：https://leetcode-cn.com/problems/open-the-lock/
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字：'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OpenLock {
	public static void main(String[] args) {
		OpenLock openLock = new OpenLock();
		int i = openLock.openLockV2(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
		System.out.println(i);
	}

	public int openLockV2(String[] deadends, String target) {
		Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
		// 用集合不用队列，可以快速判断元素是否存在
		Set<String> q1 = new HashSet<>();
		Set<String> q2 = new HashSet<>();
		Set<String> visited = new HashSet<>();
		q1.add("0000");
		q2.add(target);
		int step = 0;
		while (!q1.isEmpty() && !q2.isEmpty()) {
			if (q1.size() > q2.size()) {
				Set<String> temp = q1;
				q1 = q2;
				q2 = temp;
			}
			Set<String> tempSet = new HashSet<>();
			for (String cur : q1) {
				if (q2.contains(cur)) {
					return step;
				}
				if (deadSet.contains(cur)) {
					continue;
				}
				visited.add(cur);
				for (int i = 0; i < 4; i++) {
					String plusOne = plusOne(cur, i);
					if (!visited.contains(plusOne)) {
						tempSet.add(plusOne);
					}
					String minusOne = minusOne(cur, i);
					if (!visited.contains(minusOne)) {
						tempSet.add(minusOne);
					}
				}
			}
			step++;
			q1 = q2;
			q2 = tempSet;
		}
		return -1;
	}

	public int openLock(String[] deadends, String target) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
		String start = "0000";
		if (deadSet.contains(start)) return -1;
		if (start.equals(target)) return 0;
		queue.offer(start);

		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String poll = queue.poll();
				for (int i1 = 0; i1 < 4; i1++) {
					String plusOne = plusOne(poll, i1);
					if (!deadSet.contains(plusOne) && !visited.contains(plusOne)) {
						if (plusOne.equals(target)) return ++depth;
						visited.add(plusOne);
						queue.offer(plusOne);
					}
					String minusOne = minusOne(poll, i1);
					if (!deadSet.contains(minusOne) && !visited.contains(minusOne)) {
						if (minusOne.equals(target)) return ++depth;
						visited.add(minusOne);
						queue.offer(minusOne);
					}
				}
			}

			depth++;
		}
		return -1;
	}

	public String minusOne(String str, int index) {
		char[] chars = str.toCharArray();
		if (chars[index] == '0')
			chars[index] = '9';
		else
			chars[index]--;
		return new String(chars);
	}

	public String plusOne(String str, int index) {
		char[] chars = str.toCharArray();
		if (chars[index] == '9')
			chars[index] = '0';
		else
			chars[index]++;
		return new String(chars);
	}
}
