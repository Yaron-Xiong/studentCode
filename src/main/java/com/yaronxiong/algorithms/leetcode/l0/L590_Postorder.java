package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 590. N 叉树的后序遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * 示例 2：
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * 提示：
 * <p>
 * 节点总数在范围 [0, 104] 内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-02-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L590_Postorder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<Node> deque = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();
            ans.add(node.val);
            for (Node child : node.children) {
                deque.addFirst(child);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
