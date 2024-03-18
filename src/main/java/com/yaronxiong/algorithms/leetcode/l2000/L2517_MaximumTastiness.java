package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.*;

/**
 * 2517. 礼盒的最大甜蜜度
 * 提示
 * 中等
 * 52
 * 相关企业
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * <p>
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * <p>
 * 返回礼盒的 最大 甜蜜度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 * 示例 2：
 * <p>
 * 输入：price = [1,3,1], k = 2
 * 输出：2
 * 解释：选出价格分别为 [1,3] 的两类糖果。
 * 礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
 * 可以证明能够取得的最大甜蜜度就是 2 。
 * 示例 3：
 * <p>
 * 输入：price = [7,7,7,7], k = 2
 * 输出：0
 * 解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= price.length <= 105
 * 1 <= price[i] <= 109
 * 2 <= k <= price.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2517_MaximumTastiness {
    public static void main(String[] args) {
        L2517_MaximumTastiness l2517MaximumTastiness = new L2517_MaximumTastiness();
        System.out.println(l2517MaximumTastiness.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0;
        int right = price[price.length - 1] - price[0];
        while (left <= right) {
            int mid = (left + right) >> 1;
            //如果从price中选择k个节点能抵达Mid
            //那么有可能从price中选择k个节点抵达[mid~right]
            boolean check = check(price, k, mid);
            if (check) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    /**
     * 检查选择k个节点能否抵达目的地 mid
     */
    private boolean check(int[] price, int k, int mid) {
        //遍历price，看差值超过mid的能否有k个
        int cnt = 0;
        int pre = -mid;
        for (int i : price) {
            if (i - pre >= mid) {
                pre = i;
                cnt++;
            }
        }
        return cnt >= k;
    }

}
