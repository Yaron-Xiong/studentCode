package com.accompnay.TopicAlgorithms.swordFingerOffer.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 */
public class Permutation {
	List<String> res = new LinkedList<>();
	char[] c;

	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		String[] abcs = permutation.permutation("abcd");
		System.out.println(Arrays.toString(abcs));
	}

	public String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		return res.toArray(new String[res.size()]);
	}

	private void dfs(int x) {
		if (x == c.length - 1) {
			res.add(new String(c));
			return;
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = x; i < c.length; i++) {
			if (set.contains(c[i])) {
				continue;
			}
			set.add(c[i]);
			swap(i, x);
			dfs(x + 1);
			swap(i, x);
		}
	}

	private void swap(int i, int x) {
		char temp = c[i];
		c[i] = c[x];
		c[x] = temp;
	}

}
