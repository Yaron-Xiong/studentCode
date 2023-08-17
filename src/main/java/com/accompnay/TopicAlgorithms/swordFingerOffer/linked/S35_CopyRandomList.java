package com.accompnay.TopicAlgorithms.swordFingerOffer.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 中等
 * 763
 * 相关企业
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S35_CopyRandomList {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        //拷贝一份节点
        Node curNode = head;
        while (curNode != null) {
            Node next = curNode.next;
            Node newNode = new Node(curNode.val);
            newNode.next = next;
            curNode.next = newNode;
            curNode = next;
        }
        //设置copyNode的random指针
        curNode = head;
        while (curNode != null) {
            Node copyNode = curNode.next;
            Node nextNode = copyNode.next;
            copyNode.random = curNode.random == null ? null : curNode.random.next;
            curNode = nextNode;
        }
        // 剥离
        curNode = head;
        Node copyNodeHead = head.next;
        while (curNode != null) {
            Node copyNode = curNode.next;
            Node nextNode = copyNode.next;
            curNode.next = nextNode;
            copyNode.next = nextNode == null ? null : nextNode.next;
            curNode = nextNode;
        }
        return copyNodeHead;
    }

    public Node copyRandomList(Node head) {
        //real -> dummy
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node curNode = head;
        Node curDummy = dummy;
        while (curNode != null) {
            Node temp = map.computeIfAbsent(curNode, k -> new Node(k.val));
            curDummy.next = temp;
            if (curNode.random != null) {
                temp.random = map.computeIfAbsent(curNode.random, k -> new Node(k.val));
            }
            curNode = curNode.next;
            curDummy = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(13);
        node.random = null;

        node.next.next = new Node(11);
        node.next.random = node;

        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;
        S35_CopyRandomList s35CopyRandomList = new S35_CopyRandomList();
        Node list = s35CopyRandomList.copyRandomList2(node);
        System.out.println(list);
    }
}
