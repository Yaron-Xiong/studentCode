package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1233. 删除子文件夹
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * <p>
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * folder[j] 的子文件夹必须以 folder[j] 开头，后跟一个 "/"。例如，"/a/b" 是 "/a" 的一个子文件夹，但 "/b" 不是 "/a/b/c" 的一个子文件夹。
 * <p>
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * <p>
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * 示例 2：
 * <p>
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]
 * 输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
 * 示例 3：
 * <p>
 * 输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * 输出: ["/a/b/c","/a/b/ca","/a/b/d"]
 * <p>
 * 提示：
 * <p>
 * 1 <= folder.length <= 4 * 104
 * 2 <= folder[i].length <= 100
 * folder[i] 只包含小写字母和 '/'
 * folder[i] 总是以字符 '/' 起始
 * folder 每个元素都是 唯一 的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/description/?envType=daily-question&envId=2025-07-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1233_RemoveSubfolders {
    public static void main(String[] args) {
        L1233_RemoveSubfolders l1233RemoveSubfolders = new L1233_RemoveSubfolders();
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> res = l1233RemoveSubfolders.removeSubfolders(folder);
        System.out.println(res);
        folder = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        res = l1233RemoveSubfolders.removeSubfolders(folder);
        System.out.println(res);
        folder = new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"};
        res = l1233RemoveSubfolders.removeSubfolders(folder);
    }

    public static class Node {
        private Node[] children;
        private char node;

        public Node(char node) {
            this.node = node;
            this.children = new Node[26];
        }

        public Node[] getChildren() {
            return children;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        Node root = new Node('a');
        boolean[] delete = new boolean[folder.length];
        for (int i = 0; i < folder.length; i++) {
            String fold = folder[i];
            String[] split = fold.split("/");
            Node curNode = root;
            for (int j = 0; j < split.length; j++) {
                if (split[j].isEmpty()) {
                    continue;
                }
                int index = split[j].charAt(0) - 'a';
                Node nextNode = curNode.getChildren()[index];
                if (nextNode != null && j == split.length - 1) {
                    delete[i] = true;
                    break;
                }
                if (nextNode == null) {
                    nextNode = new Node(split[j].charAt(0));
                    curNode.getChildren()[index] = nextNode;
                }
                curNode = nextNode;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if (!delete[i]) {
                res.add(folder[i]);
            }
        }
        return res;
    }
}
