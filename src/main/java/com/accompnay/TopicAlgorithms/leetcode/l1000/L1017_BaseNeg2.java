package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1017. 负二进制转换
 * 提示
 * 中等
 * 81
 * 相关企业
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * <p>
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："110"
 * 解释：(-2)2 + (-2)1 = 2
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出："111"
 * 解释：(-2)2 + (-2)1 + (-2)0 = 3
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出："100"
 * 解释：(-2)2 = 4
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/convert-to-base-2/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1017_BaseNeg2 {
	public static void main(String[] args) {
		System.out.println(new L1017_BaseNeg2().baseNeg2(2));

	}

	public String baseNeg2(int n) {
		if (n == 0) {
			return "0";
		}
		//n%2 会有两种结果 0，1，-1
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			if (n % -2 != 0) {
				if (n < 0) {
					//当n为负数 则当前n %-2 为-1 需要先n-1 让余数变为1
					n = (n - 1) / -2;
				} else {
					n = n / -2;
				}
				sb.append("1");
			} else {
				sb.append("0");
				n = n / -2;
			}
		}
		return sb.reverse().toString();
	}
}
