package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.*;

/**
 * 2003. 每棵子树内缺失的最小基因值
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 有一棵根节点为 0 的 家族树 ，总共包含 n 个节点，节点编号为 0 到 n - 1 。
 * 给你一个下标从 0 开始的整数数组 parents ，其中 parents[i] 是节点 i 的父节点。由于节点 0 是 根 ，所以 parents[0] == -1 。
 * <p>
 * 总共有 105 个基因值，每个基因值都用 闭区间 [1, 105] 中的一个整数表示。
 * 给你一个下标从 0 开始的整数数组 nums ，其中 nums[i] 是节点 i 的基因值，且基因值 互不相同 。
 * <p>
 * 请你返回一个数组 ans ，长度为 n ，其中 ans[i] 是以节点 i 为根的子树内 缺失 的 最小 基因值。
 * <p>
 * 节点 x 为根的 子树 包含节点 x 和它所有的 后代 节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：parents = [-1,0,0,2], nums = [1,2,3,4]
 * 输出：[5,1,1,1]
 * 解释：每个子树答案计算结果如下：
 * - 0：子树包含节点 [0,1,2,3] ，基因值分别为 [1,2,3,4] 。5 是缺失的最小基因值。
 * - 1：子树只包含节点 1 ，基因值为 2 。1 是缺失的最小基因值。
 * - 2：子树包含节点 [2,3] ，基因值分别为 [3,4] 。1 是缺失的最小基因值。
 * - 3：子树只包含节点 3 ，基因值为 4 。1是缺失的最小基因值。
 * 示例 2：
 * <p>
 * 输入：parents = [-1,0,1,0,3,3], nums = [5,4,6,2,1,3]
 * 输出：[7,1,1,4,2,1]
 * 解释：每个子树答案计算结果如下：
 * - 0：子树内包含节点 [0,1,2,3,4,5] ，基因值分别为 [5,4,6,2,1,3] 。7 是缺失的最小基因值。
 * - 1：子树内包含节点 [1,2] ，基因值分别为 [4,6] 。 1 是缺失的最小基因值。
 * - 2：子树内只包含节点 2 ，基因值为 6 。1 是缺失的最小基因值。
 * - 3：子树内包含节点 [3,4,5] ，基因值分别为 [2,1,3] 。4 是缺失的最小基因值。
 * - 4：子树内只包含节点 4 ，基因值为 1 。2 是缺失的最小基因值。
 * - 5：子树内只包含节点 5 ，基因值为 3 。1 是缺失的最小基因值。
 * 示例 3：
 * <p>
 * 输入：parents = [-1,2,3,0,2,4,1], nums = [2,3,4,5,6,7,8]
 * 输出：[1,1,1,1,1,1,1]
 * 解释：所有子树都缺失基因值 1 。
 * <p>
 * 提示：
 * <p>
 * n == parents.length == nums.length
 * 2 <= n <= 105
 * 对于 i != 0 ，满足 0 <= parents[i] <= n - 1
 * parents[0] == -1
 * parents 表示一棵合法的树。
 * 1 <= nums[i] <= 105
 * nums[i] 互不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/description/?envType=daily-question&envId=2023-10-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2003_SmallestMissingValueSubtree {
    public static void main(String[] args) {
        L2003_SmallestMissingValueSubtree l2003SmallestMissingValueSubtree = new L2003_SmallestMissingValueSubtree();
        int[] ints = l2003SmallestMissingValueSubtree.smallestMissingValueSubtree(new int[]{-1, 0, 1, 0, 3, 3}, new int[]{5, 4, 6, 2, 1, 3});
        System.out.println(Arrays.toString(ints));
    }

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int[] ans = new int[parents.length];
        //假设大家都缺1
        Arrays.fill(ans, 1);
        //尝试找到基因为1的节点，然后更新基因为1节点整体链路的最小基因值
        int node = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                node = i;
            }
        }
        //说明不存在1这个最小基于，则说明整个树的最小基因为1
        if (node == -1) {
            return ans;
        }
        List<Integer>[] g = new List[parents.length];
        Arrays.setAll(g, (a) -> new ArrayList<>());
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                continue;
            }
            g[parents[i]].add(i);
        }
        boolean[] visit = new boolean[parents.length];
        int minNum = 2;
        Set<Integer> numSet = new HashSet<>();
        //开始修改node=1的这条链路最小基因,只到找到最顶层
        while (node >= 0) {
            dfs(node, g, visit, nums,numSet);
            while (numSet.contains(minNum)) {
                minNum++;
            }
            ans[node] = minNum;
            node = parents[node];
        }
        return ans;
    }

    private void dfs(int node, List<Integer>[] g, boolean[] visit, int[] nums, Set<Integer> numSet) {
        if (visit[node]) {
            return;
        }
        visit[node] = true;
        numSet.add(nums[node]);
        for (Integer child : g[node]) {
            dfs(child, g, visit, nums, numSet);
        }
    }
}
