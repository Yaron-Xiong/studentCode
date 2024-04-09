package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 331. 验证二叉树的前序序列化
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * <p>
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * <p>
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的
 * <p>
 * 例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * 注意：不允许重建树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: preorder = "1,#"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: preorder = "9,#,#,1"
 * 输出: false
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 104
 * preorder 由以逗号 “，” 分隔的 [0,100] 范围内的整数和 “#” 组成
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/description/?envType=daily-question&envId=2024-03-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L331_IsValidSerialization {
    public static void main(String[] args) {
        L331_IsValidSerialization l331IsValidSerialization = new L331_IsValidSerialization();
        System.out.println(l331IsValidSerialization.isValidSerialization("1,#"));
    }

    public boolean isValidSerialization(String preorder) {
        String[] nodeArray = preorder.split(",");
        if (nodeArray[0].equals("#")) {
            return nodeArray.length == 1;
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(2);
        int index = 1;
        while (!deque.isEmpty() && index < nodeArray.length) {
            String node = nodeArray[index++];
            int preNode = deque.pollFirst();
            preNode--;
            if (preNode != 0) {
                deque.addFirst(preNode);
            }
            if (!node.equals("#")) {
                deque.addFirst(2);
            }
        }
        return deque.isEmpty() && index == nodeArray.length;
    }
}
