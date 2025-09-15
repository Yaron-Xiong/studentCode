package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2327. 知道秘密的人数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 在第 1 天，有一个人发现了一个秘密。
 * <p>
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。
 * 同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
 * <p>
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, delay = 2, forget = 4
 * 输出：5
 * 解释：
 * 第 1 天：假设第一个人叫 A 。（一个人知道秘密）
 * 第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
 * 第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
 * 第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
 * 第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
 * 示例 2：
 * <p>
 * 输入：n = 4, delay = 1, forget = 3
 * 输出：6
 * 解释：
 * 第 1 天：第一个知道秘密的人为 A 。（一个人知道秘密）
 * 第 2 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 3 天：A 和 B 把秘密分享给 2 个新的人 C 和 D 。（四个人知道秘密）
 * 第 4 天：A 忘记了秘密，B、C、D 分别分享给 3 个新的人。（六个人知道秘密）
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * 1 <= delay < forget <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-people-aware-of-a-secret/description/?envType=daily-question&envId=2025-09-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2327_PeopleAwareOfSecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        // known[i] 表示恰好在第 i 天得知秘密的人数
        int[] known = new int[n + 1];
        known[1] = 1;
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            // 统计在第 n 天没有忘记秘密的人数
            // 这要求 i+forget-1 >= n，解得 i >= n-forget+1
            if (i >= n - forget + 1) {
                ans += known[i];
            }
            // 恰好在第 i 天得知秘密的人，会在第 [i+delay, i+forget-1] 天分享秘密
            for (int j = i + delay; j <= Math.min(i + forget - 1, n); j++) {
                known[j] = (known[j] + known[i]) % MOD; // known[j] += known[i]
            }
        }
        return (int) (ans % MOD);
    }
}
