package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3499. 操作后最大活跃区段数 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的二进制字符串 s，其中：
 * <p>
 * '1' 表示一个 活跃 区段。
 * '0' 表示一个 非活跃 区段。
 * 你可以执行 最多一次操作 来最大化 s 中的活跃区段数量。在一次操作中，你可以：
 * <p>
 * 将一个被 '0' 包围的连续 '1' 区块转换为全 '0'。
 * 然后，将一个被 '1' 包围的连续 '0' 区块转换为全 '1'。
 * 返回在执行最优操作后，s 中的 最大 活跃区段数。
 * <p>
 * 注意：处理时需要在 s 的两侧加上 '1' ，即 t = '1' + s + '1'。这些加上的 '1' 不会影响最终的计数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "01"
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 因为没有被 '0' 包围的 '1' 区块，因此无法进行有效操作。最大活跃区段数为 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "0100"
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 字符串 "0100" → 两端加上 '1' 后得到 "101001" 。
 * 选择 "0100"，"101001" → "100001" → "111111" 。
 * 最终的字符串去掉两端的 '1' 后为 "1111" 。最大活跃区段数为 4。
 * 示例 3：
 * <p>
 * 输入： s = "1000100"
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * 字符串 "1000100" → 两端加上 '1' 后得到 "110001001" 。
 * 选择 "000100"，"110001001" → "110000001" → "111111111"。
 * 最终的字符串去掉两端的 '1' 后为 "1111111"。最大活跃区段数为 7。
 * 示例 4：
 * <p>
 * 输入： s = "01010"
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 字符串 "01010" → 两端加上 '1' 后得到 "1010101"。
 * 选择 "010"，"1010101" → "1000101" → "1111101"。
 * 最终的字符串去掉两端的 '1' 后为 "11110"。最大活跃区段数为 4。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == s.length <= 105
 * s[i] 仅包含 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximize-active-section-with-trade-i/description/?envType=daily-question&envId=2026-07-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3499_MaxActiveSectionsAfterTrade {
    public static void main(String[] args) {
        L3499_MaxActiveSectionsAfterTrade l3499MaxActiveSectionsAfterTrade = new L3499_MaxActiveSectionsAfterTrade();
        System.out.println(l3499MaxActiveSectionsAfterTrade.maxActiveSectionsAfterTrade("10110"));
        System.out.println(l3499MaxActiveSectionsAfterTrade.maxActiveSectionsAfterTrade("01"));
        System.out.println(l3499MaxActiveSectionsAfterTrade.maxActiveSectionsAfterTrade("0100"));
        System.out.println(l3499MaxActiveSectionsAfterTrade.maxActiveSectionsAfterTrade("1000100"));
        System.out.println(l3499MaxActiveSectionsAfterTrade.maxActiveSectionsAfterTrade("01010"));
    }
    public int maxActiveSectionsAfterTrade(String s) {
        s += '1';
        int preZeroBlockSize = 0;
        int zeroCnt = 0;
        int mergeZeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroCnt++;
            }else {
                if (preZeroBlockSize != 0 && zeroCnt != 0) {
                    mergeZeroCnt = Math.max(mergeZeroCnt, zeroCnt + preZeroBlockSize);
                }
                if (zeroCnt != 0) {
                    preZeroBlockSize = zeroCnt;
                }
                zeroCnt = 0;
                oneCnt++;
            }
        }
        return mergeZeroCnt + oneCnt - 1;
    }
}
