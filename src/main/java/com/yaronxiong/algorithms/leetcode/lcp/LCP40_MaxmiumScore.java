package com.yaronxiong.algorithms.leetcode.lcp;

import java.util.ArrayList;
import java.util.List;

/**
 * LCP 40. 心算挑战
 * 简单
 * 相关标签
 * 相关企业
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
 * 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。
 * 若不存在获取有效得分的卡牌方案，则返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：cards = [1,2,8,9], cnt = 3
 * <p>
 * 输出：18
 * <p>
 * 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
 * <p>
 * 示例 2：
 * <p>
 * 输入：cards = [3,3,1], cnt = 1
 * <p>
 * 输出：0
 * <p>
 * 解释：不存在获取有效得分的卡牌方案。
 * <p>
 * 提示：
 * <p>
 * 1 <= cnt <= cards.length <= 10^5
 * 1 <= cards[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/uOAnQW/description/?envType=daily-question&envId=2024-08-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP40_MaxmiumScore {
    public static void main(String[] args) {
        LCP40_MaxmiumScore lcp40MaxmiumScore = new LCP40_MaxmiumScore();
        int i = lcp40MaxmiumScore.maxmiumScore(new int[]{7, 5}, 2);
        System.out.println(i);
    }

    public int maxmiumScore(int[] cards, int cnt) {
        //从cards 选cnt张牌 筹齐偶数
        //如果要选择奇数的牌，那么得再选一张奇数牌
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int card : cards) {
            if (card % 2 == 0) {
                evens.add(card);
            } else if (card % 2 == 1) {
                odds.add(card);
            }
        }
        odds.sort((a, b) -> b - a);
        evens.sort((a, b) -> b - a);
        //建立前缀和
        int[] oddsPreSum = new int[odds.size() + 1];
        for (int i = 0; i < odds.size(); i++) {
            oddsPreSum[i + 1] = oddsPreSum[i] + odds.get(i);
        }
        int[] evensPreSum = new int[evens.size() + 1];
        for (int i = 0; i < evens.size(); i++) {
            evensPreSum[i + 1] = evensPreSum[i] + evens.get(i);
        }
        //假设全部选择偶数
        int ans = 0;
        for (int evensCnt = Math.min(cnt, evens.size()); evensCnt >= 0; evensCnt--) {
            //此时计算结果
            int needOddCnt = cnt - evensCnt;
            //如果奇数的个数不是偶数个那么不符合答案
            if (needOddCnt % 2 != 0 || needOddCnt >= oddsPreSum.length) {
                continue;
            }
            //那么结果
            int v = evensPreSum[evensCnt] + oddsPreSum[needOddCnt];
            ans = Math.max(ans, v);
        }
        return ans;
    }
}
