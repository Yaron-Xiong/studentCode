package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.HashMap;
import java.util.Map;

/**
 * 1542. 找出最长的超赞子字符串
 * 算术评级: 8
 * 第 32 场双周赛
 * Q4
 * 2222
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
 * <p>
 * 「超赞子字符串」需满足满足下述两个条件：
 * <p>
 * 该字符串是 s 的一个非空子字符串
 * 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3242415"
 * 输出：5
 * 解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
 * 示例 2：
 * <p>
 * 输入：s = "12345678"
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = "213123"
 * 输出：6
 * 解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
 * 示例 4：
 * <p>
 * 输入：s = "00"
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 仅由数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-longest-awesome-substring/description/?envType=daily-question&envId=2024-05-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1542_LongestAwesome {
    public static void main(String[] args) {
        L1542_LongestAwesome l1542LongestAwesome = new L1542_LongestAwesome();
        System.out.println(l1542LongestAwesome.longestAwesome("213123"));
    }

    public int longestAwesome(String s) {
        char[] array = s.toCharArray();
        int ans = 1;
        int sequence = 0;
        //preSum -> Index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            int digit = s.charAt(i) - '0';
            sequence ^= (1 << digit);
            //求两个可能性
            //1.假设前面有个index 与i 构成奇数，的最大长度
            //根据数学有 preSum[i+1] ^ preSum[j] == 1<<k
            for (int k = 0; k < 10; k++) {
                if (map.containsKey(sequence ^ (1 << k))) {
                    ans = Math.max(ans, i - map.get(sequence ^ (1 << k)));
                }
            }
            //2.假设前面有个index 与i 构成偶数，的最大长度
            //根据数学有 preSum[i+1] ^ preSum[j] == 0
            //由于我们要求最大长度，这也是在求j的最小值
            if (map.containsKey(sequence)) {
                ans = Math.max(ans, i - map.get(sequence));
            } else {
                map.put(sequence, i);
            }
        }
        return ans;
    }
}
