package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I
 * 算术评级: 3
 * 第 378 场周赛
 * Q2
 * 1505
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
 * 3 <= s.length <= 50
 * s 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/faulty-keyboard/?envType=daily-question&envId=2024-04-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2981_MaximumLength {
    public static void main(String[] args) {
        L2981_MaximumLength l2981MaximumLength = new L2981_MaximumLength();
        System.out.println(l2981MaximumLength.maximumLength2("fafff"));
    }

    public int maximumLength2(String s) {
        PriorityQueue<Integer>[] group = new PriorityQueue[26];
        Arrays.setAll(group, a -> new PriorityQueue<>());
        int index = 0;
        char[] array = s.toCharArray();
        //n
        while (index < array.length) {
            PriorityQueue<Integer> list = group[s.charAt(index) - 'a'];
            int groupSize = 1;
            while (index + 1 < s.length() && array[index + 1] == array[index]) {
                index++;
                groupSize++;
            }
            list.add(groupSize);
            if (list.size() > 3) {
                list.poll();
            }
            index++;
        }
        int ans = -1;
        for (PriorityQueue<Integer> queue : group) {
            if (queue.isEmpty()) {
                continue;
            }
            int[] arr = new int[]{-1, -1, -1};
            int size = queue.size();
            for (int i = size - 1; i >= 0 && !queue.isEmpty(); i--) {
                arr[i] = queue.poll();
            }
            int v1 = arr[0] <= 2 ? -1 : arr[0] - 2;
            int v2 = arr[0] <= 1 ? -1 : Math.min(arr[0] - 1, arr[1]);
            int v3 = arr[2];
            int maxV = Math.max(Math.max(v1, v2), v3);
            ans = Math.max(ans, maxV);
        }
        return ans;
    }

    public int maximumLength(String s) {
        int windows = s.length() - 2;
        while (windows > 0) {
            int[] charAppearTimes = new int[26];
            int[] specialCharAppearTimes = new int[26];
            //[left,right)
            int left = 0;
            int right = 0;
            for (int i = 0; i < windows; i++) {
                charAppearTimes[s.charAt(right++) - 'a']++;
            }
            if (charAppearTimes[s.charAt(right - 1) - 'a'] == windows) {
                specialCharAppearTimes[s.charAt(right - 1) - 'a']++;
            }
            while (right < s.length()) {
                int leftIndex = s.charAt(left) - 'a';
                int rightIndex = s.charAt(right) - 'a';
                charAppearTimes[leftIndex]--;
                charAppearTimes[rightIndex]++;
                if (charAppearTimes[rightIndex] == windows) {
                    if (++specialCharAppearTimes[rightIndex] == 3) {
                        return windows;
                    }
                }
                left++;
                right++;
            }
            windows--;
        }
        return -1;
    }
}
