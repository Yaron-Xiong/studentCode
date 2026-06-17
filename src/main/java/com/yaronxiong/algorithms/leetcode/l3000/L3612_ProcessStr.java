package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3612. 用特殊操作处理字符串 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s，它由小写英文字母和特殊字符：*、# 和 % 组成。
 * <p>
 * 请根据以下规则从左到右处理 s 中的字符，构造一个新的字符串 result：
 * <p>
 * 如果字符是 小写 英文字母，则将其添加到 result 中。
 * 字符 '*' 会 删除 result 中的最后一个字符（如果存在）。
 * 字符 '#' 会 复制 当前的 result 并 追加 到其自身后面。
 * 字符 '%' 会 反转 当前的 result。
 * 在处理完 s 中的所有字符后，返回最终的字符串 result。
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "a#b%*"
 * <p>
 * 输出： "ba"
 * <p>
 * 解释：
 * <p>
 * i	s[i]	操作	当前 result
 * 0	'a'	添加 'a'	"a"
 * 1	'#'	复制 result	"aa"
 * 2	'b'	添加 'b'	"aab"
 * 3	'%'	反转 result	"baa"
 * 4	'*'	删除最后一个字符	"ba"
 * 因此，最终的 result 是 "ba"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "z*#"
 * <p>
 * 输出： ""
 * <p>
 * 解释：
 * <p>
 * i	s[i]	操作	当前 result
 * 0	'z'	添加 'z'	"z"
 * 1	'*'	删除最后一个字符	""
 * 2	'#'	复制字符串	""
 * 因此，最终的 result 是 ""。
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 20
 * s 只包含小写英文字母和特殊字符 *、# 和 %。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/process-string-with-special-operations-i/description/?envType=daily-question&envId=2026-06-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3612_ProcessStr {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else if (charAt == '#') {
                sb.append(sb);
            }else if (charAt == '%') {
                sb.reverse();
            }else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
