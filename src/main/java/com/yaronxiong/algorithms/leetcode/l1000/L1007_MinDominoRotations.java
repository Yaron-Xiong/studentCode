package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1007. 行相等的最少多米诺旋转
 * 中等
 * 相关标签
 * 相关企业
 * 在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。
 * （一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 * <p>
 * 我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。
 * <p>
 * 返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。
 * <p>
 * 如果无法做到，返回 -1.
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 图一表示：在我们旋转之前， tops 和 bottoms 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 * 示例 2：
 * <p>
 * 输入：tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * 输出：-1
 * 解释： 在这种情况下，不可能旋转多米诺牌使一行的值相等。
 * <p>
 * 提示：
 * <p>
 * 2 <= tops.length <= 2 * 104
 * bottoms.length == tops.length
 * 1 <= tops[i], bottoms[i] <= 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-domino-rotations-for-equal-row/description/?envType=daily-question&envId=2025-05-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1007_MinDominoRotations {
    public static void main(String[] args) {
        L1007_MinDominoRotations l1007MinDominoRotations = new L1007_MinDominoRotations();
        System.out.println(l1007MinDominoRotations.minDominoRotations(new int[]{2, 2, 2, 4, 4, 4}, new int[]{4, 4, 4, 2, 3, 2}));
        System.out.println(l1007MinDominoRotations.minDominoRotations(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}));
        System.out.println(l1007MinDominoRotations.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println(l1007MinDominoRotations.minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a = getMinRot(tops, bottoms, tops[0]);
        int b = getMinRot(tops, bottoms, bottoms[0]);
        return Math.min(a, b) == Integer.MAX_VALUE ? -1 : Math.min(a, b);
    }

    private int getMinRot(int[] a, int[] b, int target) {
        int aCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != target && b[i] != target) {
                return Integer.MAX_VALUE;
            }
            if (a[i] != target) {
                aCnt++;
            }
            if (b[i] != target) {
                bCnt++;
            }
        }
        return Math.min(aCnt, bCnt);
    }
}
