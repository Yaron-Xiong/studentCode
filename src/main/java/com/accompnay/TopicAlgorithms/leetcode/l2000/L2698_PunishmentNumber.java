package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2698. 求一个整数的惩罚数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * <p>
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * <p>
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：182
 * 解释：总共有 3 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * 因此，10 的惩罚数为 1 + 81 + 100 = 182
 * 示例 2：
 * <p>
 * 输入：n = 37
 * 输出：1478
 * 解释：总共有 4 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * - 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
 * 因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/?envType=daily-question&envId=2023-10-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2698_PunishmentNumber {
    public static void main(String[] args) {
        L2698_PunishmentNumber l2698PunishmentNumber = new L2698_PunishmentNumber();
        System.out.println(l2698PunishmentNumber.punishmentNumber(37));
    }

    static int[] dp = new int[1001];

    static {
        for (int i = 1; i <= 1000; i++) {
            dp[i] = dp[i - 1] + ((dfs(0, String.valueOf(i * i), i)) ? i * i : 0);
        }
    }

    public int punishmentNumber(int n) {
        return dp[n];
    }

    private static boolean dfs(int index, String str, int target) {
        if (index == str.length()) {
            return target == 0;
        }
        if (target < 0) {
            return false;
        }
        for (int i = index; i < str.length(); i++) {
            //从index~i 选择一部分作为子字符串
            String substring = str.substring(index, i + 1);
            boolean b = dfs(i + 1, str, target - Integer.parseInt(substring));
            if (b) {
                return true;
            }
        }
        return false;
    }
}
