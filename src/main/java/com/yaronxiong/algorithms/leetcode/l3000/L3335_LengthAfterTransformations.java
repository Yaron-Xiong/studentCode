package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3335. 字符串转换后的长度 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
 * <p>
 * 如果字符是 'z'，则将其替换为字符串 "ab"。
 * 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
 * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
 * <p>
 * 由于答案可能非常大，返回其对 109 + 7 取余的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "abcyy", t = 2
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * 第一次转换 (t = 1)
 * 'a' 变为 'b'
 * 'b' 变为 'c'
 * 'c' 变为 'd'
 * 'y' 变为 'z'
 * 'y' 变为 'z'
 * 第一次转换后的字符串为："bcdzz"
 * 第二次转换 (t = 2)
 * 'b' 变为 'c'
 * 'c' 变为 'd'
 * 'd' 变为 'e'
 * 'z' 变为 "ab"
 * 'z' 变为 "ab"
 * 第二次转换后的字符串为："cdeabab"
 * 最终字符串长度：字符串为 "cdeabab"，长度为 7 个字符。
 * 示例 2：
 * <p>
 * 输入： s = "azbk", t = 1
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 第一次转换 (t = 1)
 * 'a' 变为 'b'
 * 'z' 变为 "ab"
 * 'b' 变为 'c'
 * 'k' 变为 'l'
 * 第一次转换后的字符串为："babcl"
 * 最终字符串长度：字符串为 "babcl"，长度为 5 个字符。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由小写英文字母组成。
 * 1 <= t <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/total-characters-in-string-after-transformations-i/description/?envType=daily-question&envId=2025-05-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3335_LengthAfterTransformations {

    public static void main(String[] args) {
        L3335_LengthAfterTransformations l3335LengthAfterTransformations = new L3335_LengthAfterTransformations();
        System.out.println(l3335LengthAfterTransformations.lengthAfterTransformations("a", 50));
        System.out.println(l3335LengthAfterTransformations.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
    }

    private final long MOD = (long) (1e9 + 7);
    long[][] memo;

    public int lengthAfterTransformations(String s, int t) {
        //每个字符经过t步会发生什么
        memo = new long[26][t + 1];
        long ans = 0;
        for (char c : s.toCharArray()) {
            ans = ans + calChar(c, t);
            ans %= MOD;
        }
        return (int) ans;
    }

    private long calChar(char c, int t) {
        //计算距离z的距离
        int gap = 'z' - c;
        //刚好抵达z
        if (t <= gap) {
            return 1;
        }
        if (memo[c - 'a'][t] != 0) {
            return memo[c - 'a'][t];
        }
        //z分裂成a,b
        long a = calChar('a', t - gap - 1);
        long b = calChar('b', t - gap - 1);
        return memo[c - 'a'][t] = (a + b) % MOD;
    }


}
