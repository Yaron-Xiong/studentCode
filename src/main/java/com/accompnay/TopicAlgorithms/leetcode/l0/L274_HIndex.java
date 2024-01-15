package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 274. H 指数
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [3,0,6,1,5]
 * 0 1 3 5 6
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 示例 2：
 * <p>
 * 输入：citations = [1,3,1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/h-index/description/?envType=daily-question&envId=2023-10-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L274_HIndex {
    public static void main(String[] args) {
        L274_HIndex l274HIndex = new L274_HIndex();
        System.out.println(l274HIndex.hIndex(new int[]{1}));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int left = 0;
        int right = n;
        while (left < right) {
            //因为是移动右指针，需要加1
            int mid = (left + right + 1) >>> 1;
            //假设发了mid篇论文，现在去查找有没有mid篇论文的引用次数超过了 mid
            boolean c = check(citations, mid);
            //超过了 让left逼近
            if (c) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int[] citations, int mid) {
        int size = 0;
        for (int citation : citations) {
            if (citation >= mid) {
                size++;
            }
        }
        return size >= mid;
    }
}
