package com.yaronxiong.algorithms.practiceSet.list;

import java.util.Arrays;
import java.util.Random;

/**
 * 1206. 设计跳表
 * 困难
 * 248
 * 相关企业
 * 不使用任何库函数，设计一个 跳表 。
 * <p>
 * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 * <p>
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
 * <p>
 * <p>
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 * <p>
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 * <p>
 * 了解更多 : https://en.wikipedia.org/wiki/Skip_list
 * <p>
 * 在本题中，你的设计应该要包含这些函数：
 * <p>
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 * <p>
 * 示例 1:
 * <p>
 * 输入
 * ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
 * [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
 * 输出
 * [null, null, null, null, false, null, true, false, true, false]
 * <p>
 * 解释
 * Skiplist skiplist = new Skiplist();
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 * <p>
 * 提示:
 * <p>
 * 0 <= num, target <= 2 * 104
 * 调用search, add,  erase操作次数不大于 5 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/design-skiplist/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Skiplist {

	class SkiplistNode {
		int val;
		SkiplistNode[] forward;

		public SkiplistNode(int val, int maxLevel) {
			this.val = val;
			this.forward = new SkiplistNode[maxLevel];
		}
	}

	static final double P_FACTOR = 0.25;
	static final int MAX_LEVEL = 32;

	Random random;
	SkiplistNode head;
	SkiplistNode tail;
	int level;

	public Skiplist() {
		this.head = new SkiplistNode(Integer.MIN_VALUE, MAX_LEVEL);
		this.tail = new SkiplistNode(Integer.MAX_VALUE, MAX_LEVEL);
		this.level = 0;
		this.random = new Random();
		Arrays.fill(head.forward, tail);
	}

	private int getMaxLevelIndex() {
		return this.level - 1;
	}

	public boolean search(int target) {
		SkiplistNode curNode = this.head;
		for (int i = getMaxLevelIndex(); i >= 0; i--) {
			//思想：不找到当前值，而是当前值逼近当前的最大值
			while (target > curNode.forward[i].val) {
				curNode = curNode.forward[i];
			}
		}
		return curNode.forward[0].val == target;
	}

	public void add(int num) {
		//path的作用为记录 找到 逼近num值节点的路径
		//用以后面将这里路径的forward映射至新的node上
		//默认值为head的作用为：避免this.level<newNode.level 出现的空指针问题
		SkiplistNode[] path = new SkiplistNode[MAX_LEVEL];
		Arrays.fill(path, this.head);
		SkiplistNode curNode = this.head;
		for (int i = getMaxLevelIndex(); i >= 0; i--) {
			while (num > curNode.forward[i].val) {
				curNode = curNode.forward[i];
			}
			path[i] = curNode;
		}
		int newNodeLevel = getNewNodeLevel();
		this.level = Math.max(newNodeLevel, this.level);
		SkiplistNode newNode = new SkiplistNode(num, newNodeLevel);
		for (int i = 0; i < newNode.forward.length; i++) {
			newNode.forward[i] = path[i].forward[i];
			path[i].forward[i] = newNode;
		}
	}

	/**
	 * 保证每一层的节点数时上一层的一半
	 */
	private int getNewNodeLevel() {
		int level = 1;
		while (random.nextDouble() < P_FACTOR && level < MAX_LEVEL) {
			level++;
		}
		return level;
	}

	public boolean erase(int num) {
		SkiplistNode curNode = this.head;
		//为什么此处的path相比于add 没有了Arrays.fill
		//因为此处必能找到一个逼近num的最大值
		SkiplistNode[] path = new SkiplistNode[MAX_LEVEL];
		for (int i = getMaxLevelIndex(); i >= 0; i--) {
			while (num > curNode.forward[i].val) {
				curNode = curNode.forward[i];
			}
			path[i] = curNode;
		}

		curNode = curNode.forward[0];
		if (curNode.val != num) {
			return false;
		}
		//此时curNode为需要删除的节点值
		//path[i].forward[i] 为路径上的 i层节点下一个节点
		//理论上说，从0向maxLevel遍历，如果路径上有点的映射是到了 curNode
		//只需要将此映射修改为 next.next即可
		for (int i = 0; i <= this.getMaxLevelIndex(); i++) {
			if (path[i].forward[i] != curNode) {
				break;
			}
			path[i].forward[i] = curNode.forward[i];
		}

		//当一个节点移除时，会带来一个最大level值的变化,故需要重新计算最大level值
		while (level > 1 && this.head.forward[getMaxLevelIndex()] == tail) {
			level--;
		}
		return true;
	}

	public static void main(String[] args) {
		Skiplist skiplist = new Skiplist();

		/*int count = 0;
		for (int i = 0; i < 10000; i++) {
			int newNodeLevel = skiplist.getNewNodeLevel();
			count = Math.max(count, newNodeLevel);
		}
		System.out.println(count);*/


		skiplist.add(1);
		skiplist.add(3);
		skiplist.add(2);
		System.out.println(skiplist.search(0));
		skiplist.add(4);
		System.out.println(skiplist.search(1));
		System.out.println(skiplist.erase(0));
		System.out.println(skiplist.erase(1));
		System.out.println(skiplist.erase(2));
		//System.out.println(skiplist.erase(3));
		System.out.println(skiplist.erase(4));
		System.out.println(skiplist.search(1));
		System.out.println(skiplist);
	}
}
