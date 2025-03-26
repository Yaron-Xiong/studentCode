package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2269. 找到一个数字的 K 美丽值
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * <p>
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * <p>
 * 注意：
 * <p>
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 240, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "240" 中的 "24" ：24 能整除 240 。
 * - "240" 中的 "40" ：40 能整除 240 。
 * 所以，k 美丽值为 2 。
 * 示例 2：
 * <p>
 * 输入：num = 430043, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * - "430043" 中的 "30" ：30 不能整除 430043 。
 * - "430043" 中的 "00" ：0 不能整除 430043 。
 * - "430043" 中的 "04" ：4 不能整除 430043 。
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * 所以，k 美丽值为 2 。
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 109
 * 1 <= k <= num.length （将 num 视为字符串）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-k-beauty-of-a-number/description/?envType=daily-question&envId=2025-03-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2269_DivisorSubstrings {
    public static void main(String[] args) {
        L2269_DivisorSubstrings l2269DivisorSubstrings = new L2269_DivisorSubstrings();
        System.out.println(l2269DivisorSubstrings.divisorSubstrings(430043, 2));
    }

    public int divisorSubstrings(int num, int k) {
        //如何截取呢,滑动窗口
        int curNum = 0;
        int ans = 0;
        int mod = 1;
        String s = String.valueOf(num);
        for (int i = 0; i < k; i++) {
            curNum = curNum * 10 + (s.charAt(i) - '0');
            mod *= 10;
        }

        if (num % curNum == 0) {
            ans++;
        }

        for (int i = k; i < s.length(); i++) {
            //移除掉最左边的
            curNum = curNum * 10 + (s.charAt(i) - '0');
            curNum %= mod;
            if (curNum != 0 && num % curNum == 0) {
                ans++;
            }
        }
        return ans;
    }
}
