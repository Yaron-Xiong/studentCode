package com.yaronxiong.algorithms.leetcode.lcp;

/**
 * LCP 61. 气温变化趋势
 * 简单
 * 相关标签
 * 相关企业
 * 力扣城计划在两地设立「力扣嘉年华」的分会场，气象小组正在分析两地区的气温变化趋势，对于第 i ~ (i+1) 天的气温变化趋势，将根据以下规则判断：
 * <p>
 * 若第 i+1 天的气温 高于 第 i 天，为 上升 趋势
 * 若第 i+1 天的气温 等于 第 i 天，为 平稳 趋势
 * 若第 i+1 天的气温 低于 第 i 天，为 下降 趋势
 * 已知 temperatureA[i] 和 temperatureB[i] 分别表示第 i 天两地区的气温。 组委会希望找到一段天数尽可能多，且两地气温变化趋势相同的时间举办嘉年华活动。请分析并返回两地气温变化趋势相同的最大连续天数。
 * <p>
 * 即最大的 n，使得第 i~i+n 天之间，两地气温变化趋势相同
 * <p>
 * 示例 1：
 * <p>
 * 输入： temperatureA = [21,18,18,18,31] temperatureB = [34,32,16,16,17]
 * <p>
 * 输出：2
 * <p>
 * 解释：如下表所示， 第 2～4 天两地气温变化趋势相同，且持续时间最长，因此返回 4-2=2image.png
 * <p>
 * 示例 2：
 * <p>
 * 输入： temperatureA = [5,10,16,-6,15,11,3] temperatureB = [16,22,23,23,25,3,-16]
 * <p>
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 2 <= temperatureA.length == temperatureB.length <= 1000
 * -20 <= temperatureA[i], temperatureB[i] <= 40
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/6CE719/description/?envType=daily-question&envId=2024-06-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP61_TemperatureTrend {
    public static void main(String[] args) {
        LCP61_TemperatureTrend lcp61TemperatureTrend = new LCP61_TemperatureTrend();
        System.out.println(lcp61TemperatureTrend.temperatureTrend(new int[]{-14, 7, -19, 9, 13, 40, 19, 15, -18},
                new int[]{3, 16, 28, 32, 25, 12, 13, -6, 4}));
    }

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int ans = 0;
        int size = 0;
        for (int i = 1; i < n; i++) {
            int compareA = Integer.compare(temperatureA[i], temperatureA[i - 1]);
            int compareB = Integer.compare(temperatureB[i], temperatureB[i - 1]);
            if (compareA == compareB) {
                size++;
            } else {
                size = 0;
            }
            ans = Math.max(ans, size);
        }
        return ans;
    }
}
