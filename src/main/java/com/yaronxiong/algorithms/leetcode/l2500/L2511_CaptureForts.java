package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2511. 最多可以摧毁的敌人城堡数目
 * 提示
 * 简单
 * 25
 * 相关企业
 * 给你一个长度为 n ，下标从 0 开始的整数数组 forts ，表示一些城堡。forts[i] 可以是 -1 ，0 或者 1 ，其中：
 * <p>
 * -1 表示第 i 个位置 没有 城堡。
 * 0 表示第 i 个位置有一个 敌人 的城堡。
 * 1 表示第 i 个位置有一个你控制的城堡。
 * 现在，你需要决定，将你的军队从某个你控制的城堡位置 i 移动到一个空的位置 j ，满足：
 * <p>
 * 0 <= i, j <= n - 1
 * 军队经过的位置 只有 敌人的城堡。正式的，对于所有 min(i,j) < k < max(i,j) 的 k ，都满足 forts[k] == 0 。
 * 当军队移动时，所有途中经过的敌人城堡都会被 摧毁 。
 * <p>
 * 请你返回 最多 可以摧毁的敌人城堡数目。如果 无法 移动你的军队，或者没有你控制的城堡，请返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：forts = [1,0,0,-1,0,0,0,0,1]
 * 输出：4
 * 解释：
 * - 将军队从位置 0 移动到位置 3 ，摧毁 2 个敌人城堡，位置分别在 1 和 2 。
 * - 将军队从位置 8 移动到位置 3 ，摧毁 4 个敌人城堡。
 * 4 是最多可以摧毁的敌人城堡数目，所以我们返回 4 。
 * 示例 2：
 * <p>
 * 输入：forts = [0,0,1,-1]
 * 输出：0
 * 解释：由于无法摧毁敌人的城堡，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= forts.length <= 1000
 * -1 <= forts[i] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/?envType=daily-question&envId=2023-09-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2511_CaptureForts {
    public static void main(String[] args) {
        L2511_CaptureForts l2511CaptureForts = new L2511_CaptureForts();
        System.out.println(l2511CaptureForts.captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
    }

    public int captureForts(int[] forts) {
        //找到最远的 1与-1 的距离
        //找到所有的1 与-1
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == -1 || forts[i] == 1) {
                if (pre!=-1 && forts[pre] != forts[i]) {
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }
        return ans;
    }
}
