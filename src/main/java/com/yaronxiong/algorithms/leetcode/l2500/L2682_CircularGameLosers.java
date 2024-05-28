package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2682. 找出转圈游戏输家
 * 提示
 * 简单
 * 27
 * 相关企业
 * n 个朋友在玩游戏。这些朋友坐成一个圈，按 顺时针方向 从 1 到 n 编号。
 * 从第 i 个朋友的位置开始顺时针移动 1 步会到达第 (i + 1) 个朋友的位置（1 <= i < n），
 * 而从第 n 个朋友的位置开始顺时针移动 1 步会回到第 1 个朋友的位置。
 * <p>
 * 游戏规则如下：
 * <p>
 * 第 1 个朋友接球。
 * <p>
 * 接着，第 1 个朋友将球传给距离他顺时针方向 k 步的朋友。
 * 然后，接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友。
 * 接着，接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友，以此类推。
 * 换句话说，在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友。
 * <p>
 * 当某个朋友第 2 次接到球时，游戏结束。
 * <p>
 * 在整场游戏中没有接到过球的朋友是 输家 。
 * <p>
 * 给你参与游戏的朋友数量 n 和一个整数 k ，请按升序排列返回包含所有输家编号的数组 answer 作为答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, k = 2
 * 输出：[4,5]
 * 解释：以下为游戏进行情况：
 * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 2 步的玩家 —— 第 3 个朋友。
 * 2）第 3 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 2 个朋友。
 * 3）第 2 个朋友将球传给距离他顺时针方向 6 步的玩家 —— 第 3 个朋友。
 * 4）第 3 个朋友接到两次球，游戏结束。
 * 示例 2：
 * <p>
 * 输入：n = 4, k = 4
 * 输出：[2,3,4]
 * 解释：以下为游戏进行情况：
 * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 1 个朋友。
 * 2）第 1 个朋友接到两次球，游戏结束。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-losers-of-the-circular-game/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2682_CircularGameLosers {
    public static void main(String[] args) {
        L2682_CircularGameLosers l2682CircularGameLosers = new L2682_CircularGameLosers();
        System.out.println(Arrays.toString(l2682CircularGameLosers.circularGameLosers(5, 2)));
    }

    public int[] circularGameLosers(int n, int k) {
        boolean[] tags = new boolean[n];
        int count = 0;
        for (int i = 1, index = 0; ; i++) {
            if (tags[index]) {
                break;
            }
            tags[index] = true;
            count++;
            index = (index + (i * k)) % n;
        }

        int[] res = new int[n - count];
        for (int i = 0, j = 0; i < tags.length; i++) {
            if (tags[i]) {
                continue;
            }
            res[j++] = i + 1;
        }
        return res;
    }
}
