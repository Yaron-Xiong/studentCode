package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 1015. 可被 K 整除的最小整数
 * 提示
 * 中等
 * 77
 * 相关企业
 * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
 * <p>
 * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
 * <p>
 * 注意： n 不符合 64 位带符号整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 1
 * 输出：1
 * 解释：最小的答案是 n = 1，其长度为 1。
 * 示例 2：
 * <p>
 * 输入：k = 2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 n 。
 * 示例 3：
 * <p>
 * 输入：k = 3
 * 输出：3
 * 解释：最小的答案是 n = 111，其长度为 3。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1015_SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> set = new HashSet<>();
        int curN = 1 % k;
        while (curN > 0 && set.add(curN)) {
            curN = (curN * (10 % k) + 1) % k;
        }
        return curN > 0 ? -1 : set.size() + 1;
    }
}
