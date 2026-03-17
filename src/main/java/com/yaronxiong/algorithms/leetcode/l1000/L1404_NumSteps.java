package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1404. 将二进制表示减到 1 的步骤数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * <p>
 * 如果当前数字为偶数，则将其除以 2 。
 * <p>
 * 如果当前数字为奇数，则将其加上 1 。
 * <p>
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4
 * Step 5) 4  是偶数，除 2 得到 2
 * Step 6) 2  是偶数，除 2 得到 1
 * 示例 2：
 * <p>
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 * 示例 3：
 * <p>
 * 输入：s = "1"
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/?envType=daily-question&envId=2026-02-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1404_NumSteps {
    public static void main(String[] args) {
        L1404_NumSteps l1404NumSteps = new L1404_NumSteps();
        System.out.println(l1404NumSteps.numSteps("1101"));
        System.out.println(l1404NumSteps.numSteps("10"));
        System.out.println(l1404NumSteps.numSteps("1"));
    }

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int ans = 0;
        while (!(sb.length() == 1 && sb.charAt(0) == '1')) {
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                //执行+1
                int i = sb.length() - 1;
                for (; i >= 0 && sb.charAt(i) == '1'; i--) {
                    sb.setCharAt(i, '0');
                }
                if (i < 0) {
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(i, '1');
                }
            }
            ans++;
        }
        return ans;
    }
}
