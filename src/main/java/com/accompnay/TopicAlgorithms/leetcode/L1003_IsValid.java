package com.accompnay.TopicAlgorithms.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1003. 检查替换后的词是否有效
 * 中等
 * 129
 * 相关企业
 * 给你一个字符串 s ，请你判断它是否 有效 。
 * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
 * <p>
 * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
 * 如果字符串 s 有效，则返回 true；否则，返回 false。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcbc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "aabcbc"
 * 因此，"aabcbc" 有效。
 * 示例 2：
 * <p>
 * 输入：s = "abcabcababcc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * 因此，"abcabcababcc" 有效。
 * 示例 3：
 * <p>
 * 输入：s = "abccba"
 * 输出：false
 * 解释：执行操作无法得到 "abccba" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 104
 * s 由字母 'a'、'b' 和 'c' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1003_IsValid {
    public static void main(String[] args) {
        L1003_IsValid l1003IsValid = new L1003_IsValid();
        System.out.println(l1003IsValid.isValid("aaabc"));
    }

    public boolean isValid(String s) {
        //至少会有一个是连续的abc
        //abc一定是按循序出现的
        //如果每次截取abc是不是就是对的？
        Deque<Character> deque = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == 'a') {
                deque.push(c);
                continue;
            }
            if (c == 'b') {
                if (deque.isEmpty() || deque.pop() != 'a') {
                    return false;
                }
                deque.push(c);
                continue;
            }
            if (c == 'c'){
                if (deque.isEmpty() || deque.pop() != 'b') {
                    return false;
                }
                continue;
            }
        }
        return deque.isEmpty();

    }
}
