package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2171. 拿出最少数目的魔法豆
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 * <p>
 * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。
 * 一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
 * <p>
 * 请返回你需要拿出魔法豆的 最少数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：beans = [4,1,6,5]
 * 输出：4
 * 解释：
 * - 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,6,5]
 * - 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,4,5]
 * - 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,4,4]
 * 总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 4 个魔法豆更少的方案。
 * 示例 2：
 * <p>
 * 输入：beans = [2,10,3,2]
 * 输出：7
 * 解释：
 * - 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,3,2]
 * - 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,3,0]
 * - 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,0,0]
 * 总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 7 个魔法豆更少的方案。
 * <p>
 * 提示：
 * <p>
 * 1 <= beans.length <= 105
 * 1 <= beans[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/description/?envType=daily-question&envId=2024-01-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2171_MinimumRemoval {
    public static void main(String[] args) {
        L2171_MinimumRemoval l2171MinimumRemoval = new L2171_MinimumRemoval();
        System.out.println(l2171MinimumRemoval.minimumRemoval(new int[]{2, 10, 3, 2}));
    }

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        long mx = 0;
        for (int i = 0; i < beans.length; i++) {
            sum += beans[i];
            mx = Math.max(mx, (long) (beans.length - i) * beans[i]);
        }
        return sum - mx;
    }
}
