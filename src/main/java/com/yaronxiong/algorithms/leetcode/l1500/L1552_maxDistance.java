package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Arrays;

/**
 * 1552. 两球之间的磁力
 * 算术评级: 5
 * 第 202 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1920
 * 相关标签
 * 相关企业
 * 提示
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 * Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * <p>
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * <p>
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 * <p>
 * 示例 1：
 * <p>
 * 输入：position = [1,2,3,4,7], m = 3
 * 输出：3
 * 解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 * 示例 2：
 * <p>
 * 输入：position = [5,4,3,2,1,1000000000], m = 2
 * 输出：999999999
 * 解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 * <p>
 * 提示：
 * <p>
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有 position 中的整数 互不相同 。
 * 2 <= m <= position.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/magnetic-force-between-two-balls/description/?envType=daily-question&envId=2025-02-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1552_maxDistance {
    public static void main(String[] args) {
        L1552_maxDistance l1552MaxDistance = new L1552_maxDistance();
        System.out.println(l1552MaxDistance.maxDistance(new int[]{79, 74, 57, 22}, 4));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 0;
        int right = position[position.length - 1] - position[0] + 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            //假设我希望每个篮子之间的距离都 >= mid 是否可以摆放完毕
            boolean check = check(mid, position, m);
            if (check) {
                //如果可以摆放的下去则可以尝试放大
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }


    private boolean check2(int gap, int[] position, int m) {
        int pre = 0;
        for (int i = 1; i < position.length && m > 1; i++) {
            if (position[i] - position[pre] >= gap) {
                pre = i;
                m--;
            }
        }
        return m == 1;
    }
}
