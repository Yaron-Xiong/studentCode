package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2696. 删除子串后的字符串最小长度
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个仅由 大写 英文字符组成的字符串 s 。
 * <p>
 * 你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。
 * <p>
 * 通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。
 * <p>
 * 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABFCACDB"
 * 输出：2
 * 解释：你可以执行下述操作：
 * - 从 "ABFCACDB" 中删除子串 "AB"，得到 s = "FCACDB" 。
 * - 从 "FCACDB" 中删除子串 "CD"，得到 s = "FCAB" 。
 * - 从 "FCAB" 中删除子串 "AB"，得到 s = "FC" 。
 * 最终字符串的长度为 2 。
 * 可以证明 2 是可获得的最小长度。
 * 示例 2：
 * <p>
 * 输入：s = "ACBBD"
 * 输出：5
 * 解释：无法执行操作，字符串长度不变。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由大写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-01-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2696_MinLength {
    public int minLength(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!deque.isEmpty() && s.charAt(i) == 'B' && deque.peekFirst() == 'A') {
                deque.poll();
            } else if (!deque.isEmpty() && s.charAt(i) == 'D' && deque.peekFirst() == 'C') {
                deque.poll();
            } else {
                deque.addFirst(s.charAt(i));
            }
        }
        return deque.size();
    }
}
