package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1402. 做菜顺序
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
 * <p>
 * 一道菜的 「 like-time 系数 」定义为烹饪这道菜结束的时间（包含之前每道菜所花费的时间）乘以这道菜的满意程度，也就是 time[i]*satisfaction[i] 。
 * <p>
 * 返回厨师在准备了一定数量的菜肴后可以获得的最大 like-time 系数 总和。
 * <p>
 * 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：satisfaction = [-1,-8,0,5,-9]
 * 输出：14
 * 解释：去掉第二道和最后一道菜，最大的 like-time 系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。
 * 示例 2：
 * <p>
 * 输入：satisfaction = [4,3,2]
 * 输出：20
 * 解释：可以按照任意顺序做菜 (2*1 + 3*2 + 4*3 = 20)
 * 示例 3：
 * <p>
 * 输入：satisfaction = [-1,-4,-5]
 * 输出：0
 * 解释：大家都不喜欢这些菜，所以不做任何菜就可以获得最大的 like-time 系数。
 * <p>
 * 提示：
 * <p>
 * n == satisfaction.length
 * 1 <= n <= 500
 * -1000 <= satisfaction[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reducing-dishes/?envType=daily-question&envId=2023-10-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1402_MaxSatisfaction {
    public static void main(String[] args) {
        L1402_MaxSatisfaction l1402MaxSatisfaction = new L1402_MaxSatisfaction();
        System.out.println(l1402MaxSatisfaction.maxSatisfaction(new int[]{-1,-8,0,5,-9}));
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int preSum = 0;
        int res = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (satisfaction[i] + preSum < 0) {
                break;
            }
            res += preSum + satisfaction[i];
            preSum += satisfaction[i];
        }
        return res;
    }
}
