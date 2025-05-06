package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 838. 推多米诺
 * 中等
 * 相关标签
 * 相关企业
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 * <p>
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * <p>
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 * <p>
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 * <p>
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 * <p>
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 * 示例 2：
 * <p>
 * <p>
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * <p>
 * 提示：
 * <p>
 * n == dominoes.length
 * 1 <= n <= 105
 * dominoes[i] 为 'L'、'R' 或 '.'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/push-dominoes/description/?envType=daily-question&envId=2025-05-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L838_PushDominoes {
    public static void main(String[] args) {
        L838_PushDominoes l838PushDominoes = new L838_PushDominoes();
        System.out.println(l838PushDominoes.pushDominoes("R..L..R..LR.R.R....."));
        System.out.println(l838PushDominoes.pushDominoes(".L.R...LR..L.."));
        System.out.println(l838PushDominoes.pushDominoes("RR.L"));
        System.out.println(l838PushDominoes.pushDominoes(".L.R."));
    }

    public String pushDominoes(String dominoes) {
        char[] array = dominoes.toCharArray();
        int pre = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '.') {
                continue;
            }
            //判断当前节点与前一个节点的关系
            if (pre == -1) {
                if (array[i] == 'L') {
                    Arrays.fill(array, 0, i, array[i]);
                }
            } else if (array[pre] == array[i]) {
                //相等直接倒下
                Arrays.fill(array, pre + 1, i, array[i]);
            } else if (array[pre] == 'R' && array[i] == 'L') {
                //不相等，各一半
                int gapCntHalf = (i - pre - 1) / 2;
                if (gapCntHalf != 0) {
                    Arrays.fill(array, pre + 1, pre + 1 + gapCntHalf, array[pre]);
                    Arrays.fill(array, i - gapCntHalf, i, array[i]);
                }
            }
            pre = i;
        }
        if (pre >= 0 && array[pre] == 'R') {
            Arrays.fill(array, pre + 1, array.length, array[pre]);
        }
        return new String(array);
    }
}
