package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 354. 俄罗斯套娃信封问题
 * 困难
 * 870
 * 相关企业
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 * <p>
 * 示例 1：
 * <p>
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 * <p>
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= envelopes.length <= 105
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/russian-doll-envelopes/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L354_MaxEnvelopes {
	public static void main(String[] args) {
		L354_MaxEnvelopes l354MaxEnvelopes = new L354_MaxEnvelopes();
		int i = l354MaxEnvelopes.maxEnvelopes(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}});
		System.out.println(i);
	}

	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, (a, b) -> {
			int compare = Integer.compare(a[0], b[0]);
			if (compare != 0) {
				return compare;
			}
			return Integer.compare(b[1], a[1]);
		});

		List<Integer> pileList = new ArrayList<>();
		pileList.add(envelopes[0][1]);
		for (int i = 1; i < envelopes.length; i++) {
			int value = envelopes[i][1];
			int left = 0;
			int right = pileList.size();
			while (left < right) {
				int mid = (left + right) >> 1;
				if (value > pileList.get(mid)) {
					left = mid + 1;
				} else if (value < pileList.get(mid)) {
					right = mid;
				} else {
					right = mid;
				}
			}
			if (left >= pileList.size()) {
				pileList.add(value);
			} else {
				pileList.set(left, value);
			}
		}
		return pileList.size();
	}
}
