package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2734. 执行子串操作后的字典序最小字符串
 * 已解答
 * 算术评级: 4
 * 第 349 场周赛
 * Q2
 * 1405
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为：
 * <p>
 * 选择 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。
 * 例如，'b' 用 'a' 替换，'a' 用 'z' 替换。
 * 返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 现有长度相同的两个字符串 x 和 字符串 y ，在满足 x[i] != y[i] 的第一个位置 i 上，如果  x[i] 在字母表中先于 y[i] 出现，则认为字符串 x 比字符串 y 字典序更小 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cbabc"
 * 输出："baabc"
 * 解释：我们选择从下标 0 开始、到下标 1 结束的子字符串执行操作。
 * 可以证明最终得到的字符串是字典序最小的。
 * 示例 2：
 * <p>
 * 输入：s = "acbbc"
 * 输出："abaab"
 * 解释：我们选择从下标 1 开始、到下标 4 结束的子字符串执行操作。
 * 可以证明最终得到的字符串是字典序最小的。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode"
 * 输出："kddsbncd"
 * 解释：我们选择整个字符串执行操作。
 * 可以证明最终得到的字符串是字典序最小的。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-substring-operation/description/?envType=daily-question&envId=2024-06-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2734_SmallestString {
    public static void main(String[] args) {
        L2734_SmallestString l2734SmallestString = new L2734_SmallestString();
        System.out.println(l2734SmallestString.smallestString("a"));
    }

    public String smallestString(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 'a') {
                for (int j = i; j < array.length && array[j] > 'a'; j++) {
                    array[j] = (char) (array[j] - 1);
                }
                return new String(array);
            }
        }
        array[array.length - 1] = 'z';
        return new String(array);
    }
}
