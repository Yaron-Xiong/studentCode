package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 2434. 使用机器人打印字典序最小的字符串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串：
 * <p>
 * 删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。
 * 删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。
 * 请你返回纸上能写出的字典序最小的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "zza"
 * 输出："azz"
 * 解释：用 p 表示写出来的字符串。
 * 一开始，p="" ，s="zza" ，t="" 。
 * 执行第一个操作三次，得到 p="" ，s="" ，t="zza" 。
 * 执行第二个操作三次，得到 p="azz" ，s="" ，t="" 。
 * 示例 2：
 * <p>
 * 输入：s = "bac"
 * 输出："abc"
 * 解释：用 p 表示写出来的字符串。
 * 执行第一个操作两次，得到 p="" ，s="c" ，t="ba" 。
 * 执行第二个操作两次，得到 p="ab" ，s="c" ，t="" 。
 * 执行第一个操作，得到 p="ab" ，s="" ，t="c" 。
 * 执行第二个操作，得到 p="abc" ，s="" ，t="" 。
 * 示例 3：
 * <p>
 * 输入：s = "bdda"
 * 输出："addb"
 * 解释：用 p 表示写出来的字符串。
 * 一开始，p="" ，s="bdda" ，t="" 。
 * 执行第一个操作四次，得到 p="" ，s="" ，t="bdda" 。
 * 执行第二个操作四次，得到 p="addb" ，s="" ，t="" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/?envType=daily-question&envId=2025-06-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2434_RobotWithString {
    public static void main(String[] args) {
        L2434_RobotWithString l2434RobotWithString = new L2434_RobotWithString();
        //System.out.println(l2434RobotWithString.robotWithString("zza"));
        //System.out.println(l2434RobotWithString.robotWithString("bac"));
        System.out.println(l2434RobotWithString.robotWithString("bdda"));
    }

    public String robotWithString(String s) {
        char[] minSuffix = new char[s.length() + 1];
        Arrays.fill(minSuffix, 'z');
        for (int i = s.length() - 1; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(minSuffix[i + 1], s.charAt(i));
        }
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stack.addFirst(i);
            while (!stack.isEmpty() && stack.peekFirst() <= minSuffix[stack.peekFirst()]) {
                sb.append(s.charAt(stack.pollFirst()));
            }
        }
        return sb.toString();
    }
}
