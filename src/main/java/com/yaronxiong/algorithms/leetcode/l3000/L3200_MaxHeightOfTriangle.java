package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3200. 三角形的最大高度
 * 已解答
 * 算术评级: 3
 * 第 404 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1451
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 行有 3 个球，依此类推。
 * <p>
 * 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
 * <p>
 * 返回可以实现的三角形的 最大 高度。
 * <p>
 * 示例 1：
 * <p>
 * 输入： red = 2, blue = 4
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * 示例 2：
 * <p>
 * 输入： red = 2, blue = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * 示例 3：
 * <p>
 * 输入： red = 1, blue = 1
 * <p>
 * 输出： 1
 * <p>
 * 示例 4：
 * <p>
 * 输入： red = 10, blue = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * 提示：
 * <p>
 * 1 <= red, blue <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-height-of-a-triangle/description/?envType=daily-question&envId=2024-10-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3200_MaxHeightOfTriangle {
    public static void main(String[] args) {
        L3200_MaxHeightOfTriangle l3200MaxHeightOfTriangle = new L3200_MaxHeightOfTriangle();
        System.out.println(l3200MaxHeightOfTriangle.maxHeightOfTriangle(10, 1));
    }


    public int maxHeightOfTriangle(int red, int blue) {
        //要不用红色 要不用蓝色
        return Math.max(dfs(red, blue, 1), dfs(blue, red, 1));
    }

    public int dfs(int red, int blue, int curSize) {
        if (red - curSize < 0) {
            return 0;
        }
        return dfs(blue, red - curSize, curSize + 1) + 1;
    }
}
