package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 2469. 温度转换
 * 提示
 * 简单
 * 26
 * 相关企业
 * 给你一个四舍五入到两位小数的非负浮点数 celsius 来表示温度，以 摄氏度（Celsius）为单位。
 * <p>
 * 你需要将摄氏度转换为 开氏度（Kelvin）和 华氏度（Fahrenheit），并以数组 ans = [kelvin, fahrenheit] 的形式返回结果。
 * <p>
 * 返回数组 ans 。与实际答案误差不超过 10-5 的会视为正确答案。
 * <p>
 * 注意：
 * <p>
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：celsius = 36.50
 * 输出：[309.65000,97.70000]
 * 解释：36.50 摄氏度：转换为开氏度是 309.65 ，转换为华氏度是 97.70 。
 * 示例 2 ：
 * <p>
 * 输入：celsius = 122.11
 * 输出：[395.26000,251.79800]
 * 解释：122.11 摄氏度：转换为开氏度是 395.26 ，转换为华氏度是 251.798 。
 * <p>
 * 提示：
 * <p>
 * 0 <= celsius <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/convert-the-temperature/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2469_ConvertTemperature {
	public double[] convertTemperature(double celsius) {
		return new double[]{celsius + 273.15d, celsius * 1.80d + 32d};
	}
}
