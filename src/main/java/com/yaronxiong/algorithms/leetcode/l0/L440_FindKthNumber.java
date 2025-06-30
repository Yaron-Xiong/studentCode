package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 440. 字典序的第K小数字
 * 已解答
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 示例 2:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 1
 * <p>
 * 提示:
 * <p>
 * 1 <= k <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/description/?envType=daily-question&envId=2025-06-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L440_FindKthNumber {
    public static void main(String[] args) {
        L440_FindKthNumber l440FindKthNumber = new L440_FindKthNumber();
        System.out.println(l440FindKthNumber.findKthNumber(1000, 2));
    }

    public int findKthNumber(int n, int k) {
        int node = 1;
        k--;
        //从1开始遍历
        while (k > 0) {
            long size = getChildCount(node, n);
            if (k >= size) {
                node++;
                k -= size;
            }else {
                node *= 10;
                k--;
            }
        }
        return node;
    }

    private long getChildCount(int node, int n) {
        //计算node有多少个儿子
        //区间范围为 [left,right)
        long left = node;
        long right = node + 1;
        long cnt = 0;
        while (left <= n) {
            cnt += Math.min(n + 1, right) - left;
            left *= 10;
            right *= 10;
        }
        return cnt;
    }
}
