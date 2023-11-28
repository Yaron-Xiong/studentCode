package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 275. H 指数 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
 * <p>
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
 * <p>
 * 请你设计并实现对数时间复杂度的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [0,1,3,5,6]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3 。
 * 示例 2：
 * <p>
 * 输入：citations = [1,2,100]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == citations.length
 * 1 <= n <= 105
 * 0 <= citations[i] <= 1000
 * citations 按 升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/h-index-ii/description/?envType=daily-question&envId=2023-10-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L275_Hindex {
    public static void main(String[] args) {
        L275_Hindex l275Hindex = new L275_Hindex();
        System.out.println(l275Hindex.hIndex(new int[]{0, 1, 3, 5, 6}));
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            //假设 引用数为citations[n-mid] 则文章数为（n-mid)
            if (citations[n - mid] >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
