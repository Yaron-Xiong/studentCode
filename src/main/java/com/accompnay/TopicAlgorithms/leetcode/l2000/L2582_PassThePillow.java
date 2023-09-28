package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2582. 递枕头
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * n 个人站成一排，按从 1 到 n 编号。
 * <p>
 * 最初，排在队首的第一个人拿着一个枕头。每秒钟，拿着枕头的人会将枕头传递给队伍中的下一个人。
 * 一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传递枕头。
 * <p>
 * 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，然后传递给第 n - 2 个人，依此类推。
 * 给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, time = 5
 * 输出：2
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 -> 4 -> 3 -> 2 。
 * 5 秒后，枕头传递到第 2 个人手中。
 * 示例 2：
 * <p>
 * 输入：n = 3, time = 2
 * 输出：3
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 。
 * 2 秒后，枕头传递到第 3 个人手中。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * 1 <= time <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/pass-the-pillow/description/?envType=daily-question&envId=2023-09-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2582_PassThePillow {
    public static void main(String[] args) {
        L2582_PassThePillow l2582PassThePillow = new L2582_PassThePillow();
        System.out.println(l2582PassThePillow.passThePillow(4, 5));
    }

    public int passThePillow(int n, int time) {
        int last = time % (n - 1);
        if ((time / (n - 1)) % 2 == 0) {
            //说明是正向
            return 1 + last;
        } else {
            //逆向
            return n - last ;
        }
    }
}
