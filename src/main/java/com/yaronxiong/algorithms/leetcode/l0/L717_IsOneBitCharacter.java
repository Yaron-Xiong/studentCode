package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 717. 1 比特与 2 比特字符
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 有两种特殊字符：
 * <p>
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * 示例 2:
 * <p>
 * 输入：bits = [1,1,1,0]
 * 输出：false
 * 解释：唯一的解码方式是将其解析为两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 * <p>
 * 提示:
 * <p>
 * 1 <= bits.length <= 1000
 * bits[i] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/1-bit-and-2-bit-characters/description/?envType=daily-question&envId=2025-11-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L717_IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == bits.length - 1;
    }
}
