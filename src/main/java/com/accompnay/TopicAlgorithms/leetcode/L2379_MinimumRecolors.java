package com.accompnay.TopicAlgorithms.leetcode;

/**
 *
 */
public class L2379_MinimumRecolors {
	public static void main(String[] args) {
		L2379_MinimumRecolors l2379MinimumRecolors = new L2379_MinimumRecolors();
		System.out.println(l2379MinimumRecolors.minimumRecolors("WBBWWBBWBW", 7));
	}

	public int minimumRecolors(String blocks, int k) {
		int curModifyCount = 0;
		for (int i = 0; i < blocks.toCharArray().length && i < k; i ++) {
			if (blocks.charAt(i) != 'B') {
				curModifyCount++;
			}
		}
		int minModifyCount = curModifyCount;
		for (int i = k; i < blocks.toCharArray().length; i++) {
			if (blocks.charAt(i - k) != 'B') {
				curModifyCount--;
			}
			if (blocks.charAt(i) != 'B') {
				curModifyCount++;
			}
			minModifyCount = Math.min(curModifyCount, minModifyCount);
		}
		return minModifyCount;
	}
}

