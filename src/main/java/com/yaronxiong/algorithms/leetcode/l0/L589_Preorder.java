package com.yaronxiong.algorithms.leetcode.l0;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 589. N 叉树的前序遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * 提示：
 * <p>
 * 节点总数在范围 [0, 104]内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-02-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L589_Preorder {
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

    public static void main(String[] args) {
        L589_Preorder l589Preorder = new L589_Preorder();
        Node node = new Node(1);
        Node l1 = new Node(3);
        Node l2 = new Node(2);
        Node l3 = new Node(4);
        node.children = Lists.newArrayList(l1, l2, l3);
        Node l4 = new Node(5);
        Node l5 = new Node(6);
        l1.children = Lists.newArrayList(l4, l5);
        System.out.println(l589Preorder.preorder(node));
    }
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();
            ans.add(node.val);
            if (node.children == null) {
                continue;
            }
            for (int i = node.children.size() - 1; i >= 0; i--) {
                deque.addFirst(node.children.get(i));
            }
        }
        return ans;
    }
}
