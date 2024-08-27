package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 676. 实现一个魔法字典
 * 算术评级: 6
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/implement-magic-dictionary/description/?envType=daily-question&envId=2024-08-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L676_MagicDictionary {
    static class MagicDictionary {
        TrieNode root;

        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                TrieNode cur = root;
                for (int i = 0; i < s.length(); i++) {
                    int idx = s.charAt(i) - 'a';
                    if (cur.children[idx] == null) {
                        cur.children[idx] = new TrieNode();
                    }
                    cur = cur.children[idx];
                }
                cur.isFinish = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(searchWord, root, 0, false);
        }

        private boolean dfs(String searchWord, TrieNode root, int pos, boolean isModify) {
            if (pos == searchWord.length()) {
                return root.isFinish && isModify;
            }
            //替换&不替换
            //不替换
            for (int i = 0; i < root.children.length; i++) {
                int idx = searchWord.charAt(pos) - 'a';
                if (root.children[i] != null && i == idx) {
                    if (dfs(searchWord, root.children[i], pos + 1, isModify)) {
                        return true;
                    }
                }
            }
            //替换,当前位置可以替换成[0,26]
            for (int i = 0; i < root.children.length && !isModify; i++) {
                int idx = searchWord.charAt(pos) - 'a';
                if (root.children[i] != null && i != idx) {
                    if (dfs(searchWord, root.children[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class TrieNode {
        boolean isFinish = false;
        TrieNode[] children = new TrieNode[26];
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "hallo", "leetcode", "judge"});
        System.out.println(magicDictionary.search("judge"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("leetcode"));
    }

}
