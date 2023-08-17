package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.*;

/**
 * 822. 翻转卡片游戏
 * 中等
 * 39
 * 相关企业
 * 在桌子上有 N 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
 * <p>
 * 我们可以先翻转任意张卡片，然后选择其中一张卡片。
 * <p>
 * 如果选中的那张卡片背面的数字 X 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
 * <p>
 * 哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0。
 * <p>
 * 其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。
 * <p>
 * 如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。
 * <p>
 * 示例：
 * <p>
 * 输入：fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
 * 输出：2
 * 解释：假设我们翻转第二张卡片，那么在正面的数变成了 [1,3,4,4,7] ， 背面的数变成了 [1,2,4,1,3]。
 * 接着我们选择第二张卡片，因为现在该卡片的背面的数是 2，2 与任意卡片上正面的数都不同，所以 2 就是我们想要的数字。
 * <p>
 * 提示：
 * <p>
 * 1 <= fronts.length == backs.length <= 1000
 * 1 <= fronts[i] <= 2000
 * 1 <= backs[i] <= 2000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/card-flipping-game/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L822_Flipgame {
    public static void main(String[] args) {
        L822_Flipgame l822Flipgame = new L822_Flipgame();
        System.out.println(l822Flipgame.flipgame(new int[]{1, 1}, new int[]{1, 2}));
    }

    public int flipgame(int[] fronts, int[] backs) {
        //如果最小值数字命中 forbidden则说明不可能
        Set<Integer> forbidden = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                forbidden.add(fronts[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!forbidden.contains(fronts[i])) {
                ans = Math.min(fronts[i], ans);
            }
            if (!forbidden.contains(backs[i])) {
                ans = Math.min(backs[i], ans);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
