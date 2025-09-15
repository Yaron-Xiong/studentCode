package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3516. 找到最近的人
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你三个整数 x、y 和 z，表示数轴上三个人的位置：
 * <p>
 * x 是第 1 个人的位置。
 * y 是第 2 个人的位置。
 * z 是第 3 个人的位置，第 3 个人 不会移动 。
 * 第 1 个人和第 2 个人以 相同 的速度向第 3 个人移动。
 * <p>
 * 判断谁会 先 到达第 3 个人的位置：
 * <p>
 * 如果第 1 个人先到达，返回 1 。
 * 如果第 2 个人先到达，返回 2 。
 * 如果两个人同时到达，返回 0 。
 * 根据上述规则返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入： x = 2, y = 7, z = 4
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 第 1 个人在位置 2，到达第 3 个人（位置 4）需要 2 步。
 * 第 2 个人在位置 7，到达第 3 个人需要 3 步。
 * 由于第 1 个人先到达，所以输出为 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入： x = 2, y = 5, z = 6
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 第 1 个人在位置 2，到达第 3 个人（位置 6）需要 4 步。
 * 第 2 个人在位置 5，到达第 3 个人需要 1 步。
 * 由于第 2 个人先到达，所以输出为 2。
 * <p>
 * 示例 3：
 * <p>
 * 输入： x = 1, y = 5, z = 3
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 第 1 个人在位置 1，到达第 3 个人（位置 3）需要 2 步。
 * 第 2 个人在位置 5，到达第 3 个人需要 2 步。
 * 由于两个人同时到达，所以输出为 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= x, y, z <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-closest-person/description/?envType=daily-question&envId=2025-09-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3516_FindClosest {
    public int findClosest(int x, int y, int z) {
        int xDiff = Math.abs(x - z);
        int yDiff = Math.abs(y - z);
        if (xDiff == yDiff) {
            return 0;
        }
        return xDiff < yDiff ? 1 : 2;
    }
}
