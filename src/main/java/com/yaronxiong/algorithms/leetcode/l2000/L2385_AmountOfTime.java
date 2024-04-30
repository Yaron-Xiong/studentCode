package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2385. 感染二叉树需要的总时间
 * 算术评级: 5
 * 第 307 场周赛
 * Q3
 * 1711
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * <p>
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * <p>
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 * 返回感染整棵树需要的分钟数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
 * 输出：4
 * 解释：节点按以下过程被感染：
 * - 第 0 分钟：节点 3
 * - 第 1 分钟：节点 1、10、6
 * - 第 2 分钟：节点5
 * - 第 3 分钟：节点 4
 * - 第 4 分钟：节点 9 和 2
 * 感染整棵树需要 4 分钟，所以返回 4 。
 * 示例 2：
 * <p>
 * 输入：root = [1], start = 1
 * 输出：0
 * 解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 * 每个节点的值 互不相同
 * 树中必定存在值为 start 的节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected/description/?envType=daily-question&envId=2024-04-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2385_AmountOfTime {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.left.left = new TreeNode(5);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        L2385_AmountOfTime l2385AmountOfTime = new L2385_AmountOfTime();
        int i = l2385AmountOfTime.amountOfTime(root, 3);
        System.out.println(i);
    }

    public int amountOfTime(TreeNode root, int start) {
        //如果感染节点是root，那么ans = root的最大深度
        //如果感染节点在root的一侧，那么ans = Math.max(root->start的深度+root另外的一侧的最大深度 , 以start为根的最大深度)
        dfs2(root, start);
        return ans - 1;
    }

    int ans = 0;

    private int[] dfs2(TreeNode root, int start) {
        if (root == null) {
            return new int[]{-1, 0};
        }
        int[] left = dfs2(root.left, start);
        int[] right = dfs2(root.right, start);

        //{从感染节点出发，每经过一个父节点+1，当前的最大深度}
        int[] ans = new int[]{-1, Math.max(left[1], right[1]) + 1};
        if (root.val == start) {
            ans[0] = 0;
            this.ans = Math.max(this.ans, ans[1]);
        } else if (left[0] == -1 && right[0] == -1) {
            //子节点都不包含感染节点
        } else {
            //有个子节点存在感染节点,那么将子节点的感染层数进行传递
            ans[0] = Math.max(left[0], right[0]) + 1;
            //当前节点抵达感染节点的个数 + 另外一侧的高度
            int temp;
            if (left[0] >= 0) {
                temp = left[0] + right[1] + 2;
            } else {
                temp = right[0] + left[1] + 2;
            }
            this.ans = Math.max(temp, this.ans);
        }
        return ans;
    }

}
