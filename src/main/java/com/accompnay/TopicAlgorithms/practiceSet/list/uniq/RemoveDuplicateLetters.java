package com.accompnay.TopicAlgorithms.practiceSet.list.uniq;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
		String bcabc = removeDuplicateLetters.removeDuplicateLetters("ecbacba");
		System.out.println(bcabc);
	}

	public String removeDuplicateLetters(String s) {

	}
}
