package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2982. 找出出现至少三次的最长特殊子字符串 II
 * 算术评级: 5
 * 第 378 场周赛
 * Q3
 * 1773
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个仅由小写英文字母组成的字符串 s 。
 * <p>
 * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
 * <p>
 * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaa"
 * 输出：2
 * 解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
 * 可以证明最大长度是 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abcdef"
 * 输出：-1
 * 解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
 * 示例 3：
 * <p>
 * 输入：s = "abcaba"
 * 输出：1
 * 解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
 * 可以证明最大长度是 1 。
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 5 * 105
 * s 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-ii/description/?envType=daily-question&envId=2024-05-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2982_MaximumLength {
    public int maximumLength(String s) {
        PriorityQueue<Integer>[] list = new PriorityQueue[26];
        Arrays.setAll(list, a -> new PriorityQueue<>());
        char[] array = s.toCharArray();
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            size++;
            if (i + 1 == array.length || array[i + 1] != array[i]) {
                PriorityQueue<Integer> queue = list[array[i] - 'a'];
                queue.add(size);
                size = 0;
                if (queue.size() > 3) {
                    queue.poll();
                }
            }
        }

        int ans = -1;
        for (PriorityQueue<Integer> queue : list) {
            if (queue.isEmpty()) {
                continue;
            }
            int[] arr = new int[]{-1, -1, -1};
            for (int i1 = queue.size() - 1; i1 >= 0; i1--) {
                arr[i1] = queue.poll();
            }
            int v1 = arr[0] <= 2 ? -1 : arr[0] - 2;
            int v2 = arr[0] <= 1 ? -1 : Math.min(arr[0] - 1, arr[1]);
            int v3 = arr[2];
            int maxValue = Math.max(v3, Math.max(v1, v2));
            ans = Math.max(ans, maxValue);
        }
        return ans;
    }
}
