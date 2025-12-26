package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3074. 重新分装苹果
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的数组 apple 和另一个长度为 m 的数组 capacity 。
 * <p>
 * 一共有 n 个包裹，其中第 i 个包裹中装着 apple[i] 个苹果。同时，还有 m 个箱子，第 i 个箱子的容量为 capacity[i] 个苹果。
 * <p>
 * 请你选择一些箱子来将这 n 个包裹中的苹果重新分装到箱子中，返回你需要选择的箱子的 最小 数量。
 * <p>
 * 注意，同一个包裹中的苹果可以分装到不同的箱子中。
 * <p>
 * 示例 1：
 * <p>
 * 输入：apple = [1,3,2], capacity = [4,3,1,5,2]
 * 输出：2
 * 解释：使用容量为 4 和 5 的箱子。
 * 总容量大于或等于苹果的总数，所以可以完成重新分装。
 * 示例 2：
 * <p>
 * 输入：apple = [5,5,5], capacity = [2,4,2,7]
 * 输出：4
 * 解释：需要使用所有箱子。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == apple.length <= 50
 * 1 <= m == capacity.length <= 50
 * 1 <= apple[i], capacity[i] <= 50
 * 输入数据保证可以将包裹中的苹果重新分装到箱子中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/apple-redistribution-into-boxes/description/?envType=daily-question&envId=2025-12-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3074_MinimumBoxes {
    public static void main(String[] args) {
        L3074_MinimumBoxes l3074MinimumBoxes = new L3074_MinimumBoxes();
        System.out.println(l3074MinimumBoxes.minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2}));
        System.out.println(l3074MinimumBoxes.minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7}));
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int appleSum = 0;
        for (int a : apple) {
            appleSum += a;
        }
        Arrays.sort(capacity);
        int ans = 0;
        for (int i = capacity.length - 1; i >= 0 && appleSum > 0; i--) {
            ans++;
            appleSum -= capacity[i];
        }
        return ans;
    }
}
