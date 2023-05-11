package com.accompnay.TopicAlgorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 * 提示
 * 中等
 * 72
 * 相关企业
 * 给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 false 。
 * <p>
 * 子字符串 是字符串中连续的字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0110", n = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "0110", n = 4
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 不是 '0' 就是 '1'
 * 1 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1016_QueryString {
    public static void main(String[] args) {
        L1016_QueryString l1016QueryString = new L1016_QueryString();
        System.out.println(l1016QueryString.queryString("0110", 3));
    }

    public boolean queryString(String s, int n) {
        //方法1 将1~n 变成2进制 然后看 是不是s的字串

        //方法2 遍历所有的字串看最后构建的出的数字列表是不是n
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            if (x == 0) {
                continue;
            }
            for (int j = i + 1; j < s.length() && x <= n; j++) {
                set.add(x);
                x = x << 1 | (s.charAt(j) - '0');
            }
            if (x <= n) {
                set.add(x);
            }
        }
        return set.size() == n;
    }
}
