package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2555. 两个线段获得的最多奖品
 * 算术评级: 6
 * 第 97 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 2081
 * 相关标签
 * 相关企业
 * 提示
 * 在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，它按照 非递减 顺序排列，其中 prizePositions[i] 是第 i 件奖品的位置。
 * 数轴上一个位置可能会有多件奖品。再给你一个整数 k 。
 * <p>
 * 你可以选择两个端点为整数的线段。每个线段的长度都必须是 k 。
 * 你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。
 * <p>
 * 比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
 * 请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：prizePositions = [1,1,2,2,3,3,5], k = 2
 * 输出：7
 * 解释：这个例子中，你可以选择线段 [1, 3] 和 [3, 5] ，获得 7 个奖品。
 * 示例 2：
 * <p>
 * 输入：prizePositions = [1,2,3,4], k = 0
 * 输出：2
 * 解释：这个例子中，一个选择是选择线段 [3, 3] 和 [4, 4] ，获得 2 个奖品。
 * <p>
 * 提示：
 * <p>
 * 1 <= prizePositions.length <= 105
 * 1 <= prizePositions[i] <= 109
 * 0 <= k <= 109
 * prizePositions 有序非递减
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximize-win-from-two-segments/description/?envType=daily-question&envId=2024-09-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2555_MaximizeWin {
    public static void main(String[] args) {
        L2555_MaximizeWin l2555MaximizeWin = new L2555_MaximizeWin();
        System.out.println(l2555MaximizeWin.maximizeWin(new int[]{1, 1, 2, 2, 3, 3, 5}, 2));
    }

    public int maximizeWin(int[] prizePositions, int k) {
        int left = 0;
        int size = 0;
        int maxSize = size;
        int maxLeft = 0;
        for (int right = 0; right < prizePositions.length; right++) {
            size++;
            while (prizePositions[right] - prizePositions[left] > k) {
                size--;
                left++;
            }
            if (size > maxSize) {
                maxSize = size;
                maxLeft = left;
            }
        }
        left = 0;
        size = 0;
        int secondMaxSize = 0;
        for (int right = 0; right < prizePositions.length; right++) {
            //如果落在了前面的最大值,则不能加
            if (prizePositions[right] >= prizePositions[maxLeft] && prizePositions[right] <= prizePositions[maxLeft + k]) {
                continue;
            }
            size++;
            while (prizePositions[right] - prizePositions[left] > k) {
                if (prizePositions[left] < prizePositions[maxLeft] || prizePositions[left] > prizePositions[maxLeft + k]) {
                    size--;
                }
                left++;
            }
            if (size > secondMaxSize) {
                secondMaxSize = size;
            }
        }
        return maxSize + secondMaxSize;
    }

}
