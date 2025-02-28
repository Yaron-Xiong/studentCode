package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2296. 设计一个文本编辑器
 * 算术评级: 4
 * 第 296 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1912
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个带光标的文本编辑器，它可以实现以下功能：
 * <p>
 * 添加：在光标所在处添加文本。
 * 删除：在光标所在处删除文本（模拟键盘的删除键）。
 * 移动：将光标往左或者往右移动。
 * 当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，也就是说任意时候 0 <= cursor.position <= currentText.length 都成立。
 * <p>
 * 请你实现 TextEditor 类：
 * <p>
 * TextEditor() 用空文本初始化对象。
 * void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
 * int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。
 * string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TextEditor", "addText", "deleteText", "addText", "cursorRight", "cursorLeft", "deleteText", "cursorLeft", "cursorRight"]
 * [[], ["leetcode"], [4], ["practice"], [3], [8], [10], [2], [6]]
 * 输出：
 * [null, null, 4, null, "etpractice", "leet", 4, "", "practi"]
 * <p>
 * 解释：
 * TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
 * textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
 * textEditor.deleteText(4); // 返回 4
 * // 当前文本为 "leet|" 。
 * // 删除了 4 个字符。
 * textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
 * textEditor.cursorRight(3); // 返回 "etpractice"
 * // 当前文本为 "leetpractice|".
 * // 光标无法移动到文本以外，所以无法移动。
 * // "etpractice" 是光标左边的 10 个字符。
 * textEditor.cursorLeft(8); // 返回 "leet"
 * // 当前文本为 "leet|practice" 。
 * // "leet" 是光标左边的 min(10, 4) = 4 个字符。
 * textEditor.deleteText(10); // 返回 4
 * // 当前文本为 "|practice" 。
 * // 只有 4 个字符被删除了。
 * textEditor.cursorLeft(2); // 返回 ""
 * // 当前文本为 "|practice" 。
 * // 光标无法移动到文本以外，所以无法移动。
 * // "" 是光标左边的 min(10, 0) = 0 个字符。
 * textEditor.cursorRight(6); // 返回 "practi"
 * // 当前文本为 "practi|ce" 。
 * // "practi" 是光标左边的 min(10, 6) = 6 个字符。
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length, k <= 40
 * text 只含有小写英文字母。
 * 调用 addText ，deleteText ，cursorLeft 和 cursorRight 的 总 次数不超过 2 * 104 次。
 * <p>
 * 进阶：你能设计并实现一个每次调用时间复杂度为 O(k) 的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/design-a-text-editor/description/?envType=daily-question&envId=2025-02-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2296_TextEditor {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("jxarid");
        System.out.println(textEditor.cursorLeft(5));
        System.out.println(textEditor.cursorLeft(10));
        textEditor.addText("du");
        System.out.println(textEditor.deleteText(20));
    }

    static class TextEditor {
        class Node {
            private char character;
            private Node next;
            private Node prev;

            public Node(char character) {
                this.character = character;
            }

            @Override
            public String toString() {
                if (next != null) {
                    return character + ":" + next.toString();
                }
                return String.valueOf(character);
            }
        }

        Node head;
        Node tail;
        Node pos;

        public TextEditor() {
            head = new Node('#');
            tail = new Node('#');
            pos = new Node('#');
            merge(head, pos, tail);
        }

        private void merge(Node left, Node mid, Node right) {
            left.next = mid;
            mid.prev = left;

            right.prev = mid;
            mid.next = right;
        }

        public void addText(String text) {
            Node cur = pos;
            Node lastNode = cur;
            for (int i = 0; i < text.length(); i++) {
                Node newNode = new Node(text.charAt(i));
                merge(cur, newNode, cur.next);
                lastNode = newNode;
                cur = newNode;
            }
            //移动光标到最后
            delNode(pos);
            merge(lastNode, pos, lastNode.next);
        }

        public int deleteText(int k) {
            int ans = 0;
            Node preNode = pos;
            while (preNode.prev != null && preNode.prev.prev != null && k > 0) {
                preNode = preNode.prev;
                k--;
                ans++;
            }
            Node prev = preNode.prev;
            prev.next = pos;
            pos.prev = prev;
            return ans;
        }

        public String cursorLeft(int k) {
            //将光标向左边移动k
            Node curNode = pos;
            while (curNode.prev != head && k > 0) {
                curNode = curNode.prev;
                k--;
            }
            if (curNode == pos) {
                return read();
            }
            delNode(pos);
            merge(curNode.prev, pos, curNode);
            return read();
        }

        private String read() {
            Node cur = pos.prev;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10 && cur != head; i++) {
                sb.append(cur.character);
                cur = cur.prev;
            }
            sb.reverse();
            return sb.toString();
        }

        private void delNode(Node node) {
            Node pre = node.prev;
            Node next = node.next;
            pre.next = next;
            next.prev = pre;
        }

        public String cursorRight(int k) {
            //将光标向右边移动k
            Node curNode = pos;
            while (curNode.next != tail && k > 0) {
                curNode = curNode.next;
                k--;
            }
            if (curNode == pos) {
                return read();
            }
            delNode(pos);
            merge(curNode, pos, curNode.next);
            return read();
        }
    }
}
