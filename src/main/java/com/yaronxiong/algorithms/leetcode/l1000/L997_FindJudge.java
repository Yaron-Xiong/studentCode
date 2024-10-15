package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 997. 找到小镇的法官
 * 已解答
 * 算术评级: 3
 * 第 125 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1202
 * 相关标签
 * 相关企业
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 * <p>
 * 如果小镇法官真的存在，那么：
 * <p>
 * 小镇法官不会信任任何人。
 * 每个人（除了小镇法官）都信任这位小镇法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * <p>
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * trust 中的所有trust[i] = [ai, bi] 互不相同
 * ai != bi
 * 1 <= ai, bi <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-town-judge/description/?envType=daily-question&envId=2024-09-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L997_FindJudge {
    public static void main(String[] args) {
        L997_FindJudge l997FindJudge = new L997_FindJudge();
        System.out.println(l997FindJudge.findJudge(3, new int[][]{{1, 2}, {2, 3}}));
    }
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n];
        for (int[] ints : trust) {
            inDegree[ints[1] - 1]++;
            inDegree[ints[0] - 1]--;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == n - 1 ) {
                return i + 1;
            }
        }
        return -1;
    }
}
