package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 901. 股票价格跨度
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * <p>
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * <p>
 * 提示：
 * <p>
 * 1 <= price <= 105
 * 最多调用 next 方法 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/online-stock-span/description/?envType=daily-question&envId=2023-10-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L901_StockSpanner {
    public static void main(String[] args) {
        L901_StockSpanner.StockSpanner l901StockSpanner = new L901_StockSpanner.StockSpanner();
        System.out.println(l901StockSpanner.next(31));
        System.out.println(l901StockSpanner.next(41));
        System.out.println(l901StockSpanner.next(48));
        System.out.println(l901StockSpanner.next(59));
        System.out.println(l901StockSpanner.next(79));
    }

    static class StockSpanner {
        Deque<int[]> deque;
        int curIndex;

        public StockSpanner() {
            deque = new LinkedList<>();
            curIndex = 0;
        }

        public int next(int price) {
            while (!deque.isEmpty() && deque.peekFirst()[1] <= price) {
                deque.pollFirst();
            }
            int res = deque.isEmpty() ? curIndex + 1 : curIndex - deque.peekFirst()[0];
            deque.addFirst(new int[]{curIndex++, price});
            return res;
        }
    }
}
