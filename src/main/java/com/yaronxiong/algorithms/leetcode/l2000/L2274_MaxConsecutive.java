package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2274. 不含特殊楼层的最大连续楼层数
 * 算术评级: 3
 * 第 293 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1333
 * 相关标签
 * 相关企业
 * 提示
 * Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
 * <p>
 * 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。
 * 另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
 * <p>
 * 返回不含特殊楼层的 最大 连续楼层数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bottom = 2, top = 9, special = [4,6]
 * 输出：3
 * 解释：下面列出的是不含特殊楼层的连续楼层范围：
 * - (2, 3) ，楼层数为 2 。
 * - (5, 5) ，楼层数为 1 。
 * - (7, 9) ，楼层数为 3 。
 * 因此，返回最大连续楼层数 3 。
 * 示例 2：
 * <p>
 * 输入：bottom = 6, top = 8, special = [7,6,8]
 * 输出：0
 * 解释：每层楼都被规划为特殊楼层，所以返回 0 。
 * <p>
 * 提示
 * <p>
 * 1 <= special.length <= 105
 * 1 <= bottom <= special[i] <= top <= 109
 * special 中的所有值 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/description/?envType=daily-question&envId=2025-01-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2274_MaxConsecutive {
    public static void main(String[] args) {
        L2274_MaxConsecutive l2274MaxConsecutive = new L2274_MaxConsecutive();
        System.out.println(l2274MaxConsecutive.maxConsecutive(6, 8, new int[]{6, 7, 8}));
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = special[0] - bottom;
        ans = Math.max(ans, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        return ans;
    }
}
