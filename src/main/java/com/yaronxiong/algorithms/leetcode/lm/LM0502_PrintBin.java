package com.yaronxiong.algorithms.leetcode.lm;

/**
 * 面试题 05.02. 二进制数转字符串
 * 提示
 * 中等
 * 66
 * 相关企业
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>
 * 示例1:
 * <p>
 * 输入：0.625
 * 输出："0.101"
 * 示例2:
 * <p>
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * <p>
 * 提示：
 * <p>
 * 32位包括输出中的 "0." 这两位。
 * 题目保证输入用例的小数位数最多只有 6 位
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/bianry-number-to-string-lcci/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LM0502_PrintBin {

	public static void main(String[] args) {
		LM0502_PrintBin lm0502PrintBin = new LM0502_PrintBin();
		String s = lm0502PrintBin.printBin(0.1);
		System.out.println(s);
	}

	public String printBin(double num) {
		double curNum = num;
		StringBuilder binStr = new StringBuilder("0.");
		for (int i = 0; i < 33; i++) {
			curNum = curNum * 2;
			if (curNum >= 1) {
				binStr.append("1");
				curNum -= 1;
			} else if (curNum == 0) {
				break;
			} else {
				binStr.append("0");
			}
		}
		return curNum == 0 ? binStr.toString() : "ERROR";
	}
}
