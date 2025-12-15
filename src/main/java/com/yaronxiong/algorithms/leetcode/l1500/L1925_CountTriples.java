package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1925. 统计平方和三元组的数目
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
 * <p>
 * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 250
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-square-sum-triples/description/?envType=daily-question&envId=2025-12-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1925_CountTriples {
    public static void main(String[] args) {
        L1925_CountTriples l1925CountTriples = new L1925_CountTriples();
        System.out.println(l1925CountTriples.countTriples(5));
        System.out.println(l1925CountTriples.countTriples(10));
    }

    public int countTriples(int n) {
        int ans = 0;
        int n2 = n * n;
        for (int i = 1; i < n; i++) {
            int a = i * i;
            if (a > n2) {
                break;
            }
            for (int j = i + 1; j < n; j++) {
                int b = j * j;
                int c = a + b;
                if (c > n2) {
                    break;
                }
                if (Math.sqrt(c) == (int) Math.sqrt(c)) {
                    ans += 2;
                }
            }
        }
        return ans;
    }
}
