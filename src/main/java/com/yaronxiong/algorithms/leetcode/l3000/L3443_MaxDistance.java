package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3443. K 次修改后的最大曼哈顿距离
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由字符 'N'、'S'、'E' 和 'W' 组成的字符串 s，其中 s[i] 表示在无限网格中的移动操作：
 * <p>
 * 'N'：向北移动 1 个单位。
 * 'S'：向南移动 1 个单位。
 * 'E'：向东移动 1 个单位。
 * 'W'：向西移动 1 个单位。
 * 初始时，你位于原点 (0, 0)。你 最多 可以修改 k 个字符为任意四个方向之一。
 * <p>
 * 请找出在 按顺序 执行所有移动操作过程中的 任意时刻 ，所能达到的离原点的 最大曼哈顿距离 。
 * <p>
 * 曼哈顿距离 定义为两个坐标点 (xi, yi) 和 (xj, yj) 的横向距离绝对值与纵向距离绝对值之和，即 |xi - xj| + |yi - yj|。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "NWSE", k = 1
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 将 s[2] 从 'S' 改为 'N' ，字符串 s 变为 "NWNE" 。
 * <p>
 * 移动操作	位置 (x, y)	曼哈顿距离	最大值
 * s[0] == 'N'	(0, 1)	0 + 1 = 1	1
 * s[1] == 'W'	(-1, 1)	1 + 1 = 2	2
 * s[2] == 'N'	(-1, 2)	1 + 2 = 3	3
 * s[3] == 'E'	(0, 2)	0 + 2 = 2	3
 * 执行移动操作过程中，距离原点的最大曼哈顿距离是 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "NSWWEW", k = 3
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * 将 s[1] 从 'S' 改为 'N' ，将 s[4] 从 'E' 改为 'W' 。字符串 s 变为 "NNWWWW" 。
 * <p>
 * 执行移动操作过程中，距离原点的最大曼哈顿距离是 6 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * 0 <= k <= s.length
 * s 仅由 'N'、'S'、'E' 和 'W' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-manhattan-distance-after-k-changes/description/?envType=daily-question&envId=2025-06-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3443_MaxDistance {
    public static void main(String[] args) {
        L3443_MaxDistance l3443MaxDistance = new L3443_MaxDistance();
        // System.out.println(l3443MaxDistance.maxDistance("WEES", 2));
        //System.out.println(l3443MaxDistance.maxDistance("NSWWEW", 3));
        System.out.println(l3443MaxDistance.maxDistance("SN", 0));
    }

    public int maxDistance(String s, int k) {
        int[] cnt = new int[4];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == 'N') {
                cnt[0]++;
            } else if (charAt == 'S') {
                cnt[1]++;
            } else if (charAt == 'E') {
                cnt[2]++;
            } else {
                cnt[3]++;
            }
            //判断在当前位置下的最优解
            int tempK = getK(cnt[0], cnt[1], k);
            int part1 = Math.abs(cnt[0] - cnt[1]) + 2 * (k - tempK);
            int tempK2 = getK(cnt[2], cnt[3], tempK);
            int part2 = Math.abs(cnt[2] - cnt[3]) + 2 * (tempK - tempK2);
            ans = Math.max(part1 + part2, ans);
        }
        return ans;
    }

    public int getK(int a, int b, int k) {
        int min = Math.min(a, b);
        if (min >= k) {
            return 0;
        } else {
            return k - min;
        }
    }

}
