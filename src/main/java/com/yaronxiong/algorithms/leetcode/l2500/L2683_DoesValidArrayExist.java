package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2683. 相邻值的按位异或
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 下标从 0 开始、长度为 n 的数组 derived 是由同样长度为 n 的原始 二进制数组 original 通过计算相邻值的 按位异或（⊕）派生而来。
 * <p>
 * 特别地，对于范围 [0, n - 1] 内的每个下标 i ：
 * <p>
 * 如果 i = n - 1 ，那么 derived[i] = original[i] ⊕ original[0]
 * 否则 derived[i] = original[i] ⊕ original[i + 1]
 * 给你一个数组 derived ，请判断是否存在一个能够派生得到 derived 的 有效原始二进制数组 original 。
 * <p>
 * 如果存在满足要求的原始二进制数组，返回 true ；否则，返回 false 。
 * <p>
 * 二进制数组是仅由 0 和 1 组成的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：derived = [1,1,0]
 * 输出：true
 * 解释：能够派生得到 [1,1,0] 的有效原始二进制数组是 [0,1,0] ：
 * derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1
 * derived[1] = original[1] ⊕ original[2] = 1 ⊕ 0 = 1
 * derived[2] = original[2] ⊕ original[0] = 0 ⊕ 0 = 0
 * 示例 2：
 * <p>
 * 输入：derived = [1,1]
 * 输出：true
 * 解释：能够派生得到 [1,1] 的有效原始二进制数组是 [0,1] ：
 * derived[0] = original[0] ⊕ original[1] = 1
 * derived[1] = original[1] ⊕ original[0] = 1
 * 示例 3：
 * <p>
 * 输入：derived = [1,0]
 * 输出：false
 * 解释：不存在能够派生得到 [1,0] 的有效原始二进制数组。
 * <p>
 * 提示：
 * <p>
 * n == derived.length
 * 1 <= n <= 105
 * derived 中的值不是 0 就是 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/neighboring-bitwise-xor/description/?envType=daily-question&envId=2025-07-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2683_DoesValidArrayExist {
    public static void main(String[] args) {
        L2683_DoesValidArrayExist l2683DoesValidArrayExist = new L2683_DoesValidArrayExist();
        System.out.println(l2683DoesValidArrayExist.doesValidArrayExist(new int[]{1, 1, 0}));
    }

    public boolean doesValidArrayExist(int[] derived) {
        boolean pre = true;
        for (int i = 0; i < derived.length - 1; i++) {
            if (derived[i] == 1) {
                pre = !pre;
            }
        }
        if (derived[derived.length - 1] == 0) {
            return pre;
        } else {
            return !pre;
        }
    }
}
