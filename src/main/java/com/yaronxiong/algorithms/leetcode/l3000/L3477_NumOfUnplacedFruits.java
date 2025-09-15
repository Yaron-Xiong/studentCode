package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3477. 水果成篮 II
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
 * <p>
 * 你需要对 fruits 数组从左到右按照以下规则放置水果：
 * <p>
 * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
 * 每个篮子只能装 一种 水果。
 * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
 * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
 * <p>
 * 示例 1
 * <p>
 * 输入： fruits = [4,2,5], baskets = [3,5,4]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * fruits[0] = 4 放入 baskets[1] = 5。
 * fruits[1] = 2 放入 baskets[0] = 3。
 * fruits[2] = 5 无法放入 baskets[2] = 4。
 * 由于有一种水果未放置，我们返回 1。
 * <p>
 * 示例 2
 * <p>
 * 输入： fruits = [3,6,1], baskets = [6,4,7]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * fruits[0] = 3 放入 baskets[0] = 6。
 * fruits[1] = 6 无法放入 baskets[1] = 4（容量不足），但可以放入下一个可用的篮子 baskets[2] = 7。
 * fruits[2] = 1 放入 baskets[1] = 4。
 * 由于所有水果都已成功放置，我们返回 0。
 * <p>
 * 提示：
 * <p>
 * n == fruits.length == baskets.length
 * 1 <= n <= 100
 * 1 <= fruits[i], baskets[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/fruits-into-baskets-ii/description/?envType=daily-question&envId=2025-08-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3477_NumOfUnplacedFruits {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = fruits.length;
        boolean[] used = new boolean[baskets.length];
        for (int fruit : fruits) {
            for (int j = 0; j < baskets.length; j++) {
                if (used[j] || baskets[j] < fruit) {
                    continue;
                }
                used[j] = true;
                ans--;
                break;
            }
        }
        return ans;
    }
}
