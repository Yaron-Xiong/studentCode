package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2078. 两栋颜色不同且距离最远的房子
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
 * <p>
 * 返回 两栋 颜色 不同 房子之间的 最大 距离。
 * <p>
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：colors = [1,1,1,6,1,1,1]
 * 输出：3
 * 解释：上图中，颜色 1 标识成蓝色，颜色 6 标识成红色。
 * 两栋颜色不同且距离最远的房子是房子 0 和房子 3 。
 * 房子 0 的颜色是颜色 1 ，房子 3 的颜色是颜色 6 。两栋房子之间的距离是 abs(0 - 3) = 3 。
 * 注意，房子 3 和房子 6 也可以产生最佳答案。
 * 示例 2：
 * <p>
 * 输入：colors = [1,8,3,8,3]
 * 输出：4
 * 解释：上图中，颜色 1 标识成蓝色，颜色 8 标识成黄色，颜色 3 标识成绿色。
 * 两栋颜色不同且距离最远的房子是房子 0 和房子 4 。
 * 房子 0 的颜色是颜色 1 ，房子 4 的颜色是颜色 3 。两栋房子之间的距离是 abs(0 - 4) = 4 。
 * 示例 3：
 * <p>
 * 输入：colors = [0,1]
 * 输出：1
 * 解释：两栋颜色不同且距离最远的房子是房子 0 和房子 1 。
 * 房子 0 的颜色是颜色 0 ，房子 1 的颜色是颜色 1 。两栋房子之间的距离是 abs(0 - 1) = 1 。
 * <p>
 * 提示：
 * <p>
 * n == colors.length
 * 2 <= n <= 100
 * 0 <= colors[i] <= 100
 * 生成的测试数据满足 至少 存在 2 栋颜色不同的房子
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/two-furthest-houses-with-different-colors/description/?envType=daily-question&envId=2026-04-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2078_MaxDistance {
    public int maxDistance(int[] colors) {
        int ans = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < i; j++) {
                if (colors[i] == colors[j]) {
                    continue;
                }
                ans = Math.max(ans, Math.abs(i - j));
                break;
            }
            for (int j = colors.length - 1; j > i; j--) {
                if (colors[i] == colors[j]) {
                    continue;
                }
                ans = Math.max(ans, Math.abs(i - j));
                break;
            }
        }
        return ans;
    }
}
