package com.accompnay.TopicAlgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1032. 字符流
 * 提示
 * 困难
 * 107
 * 相关企业
 * 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。e
 * <p>
 * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到 "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
 * <p>
 * 按下述要求实现 StreamChecker 类：
 * <p>
 * StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
 * boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * 输出：
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 * <p>
 * 解释：
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // 返回 False
 * streamChecker.query("b"); // 返回 False
 * streamChecker.query("c"); // 返回n False
 * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
 * streamChecker.query("e"); // 返回 False
 * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
 * streamChecker.query("g"); // 返回 False
 * streamChecker.query("h"); // 返回 False
 * streamChecker.query("i"); // 返回 False
 * streamChecker.query("j"); // 返回 False
 * streamChecker.query("k"); // 返回 False
 * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 200
 * words[i] 由小写英文字母组成
 * letter 是一个小写英文字母
 * 最多调用查询 4 * 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/stream-of-characters/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1032_StreamChecker {
	static class StreamChecker {
		List<Checker> checkerList;

		public StreamChecker(String[] words) {
			checkerList = new ArrayList<>();
			for (String word : words) {
				Checker checker = new Checker(word);
				checkerList.add(checker);
			}
		}

		public boolean query(char letter) {
			boolean res = false;
			for (Checker checker : checkerList) {
				if (checker.query(letter)) {
					res = true;
				}
			}
			return res;
		}
	}

	static class Checker {
		char[] words;
		Node head;
		Node tail;
		int slidWinSize;

		static class Node {
			char node;
			Node next;
			Node pre;

			public Node(char node) {
				this.node = node;
			}

			public Node(char node, Node pre, Node next) {
				this.node = node;
				pre.next = this;
				next.pre = this;
				this.pre = pre;
				this.next = next;
			}
		}

		public Checker(String words) {
			this.words = words.toCharArray();
			head = new Node('A');
			tail = new Node('Z');
			head.next = tail;
			tail.pre = head;
			slidWinSize = 0;
		}

		public boolean query(char latter) {
			addNode(latter);
			if (slidWinSize > words.length) {
				removeHead();
			}
			return isEquate();
		}

		public boolean isEquate() {
			if (slidWinSize != words.length) {
				return false;
			}
			Node node = this.head.next;
			int index = 0;
			while (node != tail) {
				if (node.node == words[index]) {
					index++;
					node = node.next;
				} else {
					return false;
				}
			}
			return true;
		}


		public void removeHead() {
			if (slidWinSize < 1) {
				return;
			}
			Node next = this.head.next;
			this.head.next = this.head.next.next;
			this.head.next.pre = this.head;
			next.pre = null;
			next.next = null;
			slidWinSize--;
		}

		public void addNode(char latter) {
			new Node(latter, tail.pre, tail);
			slidWinSize++;
		}
	}


	public static void main(String[] args) {
		String[] words = {"baa", "aa", "aaaa", "abbbb", "aba"};
		L1032_StreamChecker.StreamChecker l1032StreamChecker = new L1032_StreamChecker.StreamChecker(words);
		char[] chars = {'a', 'a', 'a', 'b', 'a', 'b', 'a', 'a', 'b', 'a', 'b', 'a', 'b', 'b', 'a', 'a', 'a', 'b', 'b', 'a', 'b', 'a', 'a', 'a', 'a', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'a', 'b', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'};
		for (char aChar : chars) {
			System.out.println(l1032StreamChecker.query(aChar));
		}
	}
}
