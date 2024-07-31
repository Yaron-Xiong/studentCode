package com.yaronxiong.algorithms.leetcode.l0;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 721. 账户合并
 * 算术评级: 7
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * <p>
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * <p>
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：accounts = [
 * ["John", "johnsmith@mail.com", "john00@mail.com"],
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 * ["John", "johnnybravo@mail.com"],
 * ["Mary", "mary@mail.com"]
 * ]
 * 输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * 示例 2：
 * <p>
 * 输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * 输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 * <p>
 * 提示：
 * <p>
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j].length <= 30
 * accounts[i][0] 由英文字母组成
 * accounts[i][j] (for j > 0) 是有效的邮箱地址
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/accounts-merge/description/?envType=daily-question&envId=2024-07-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L721_AccountsMerge {
    public static void main(String[] args) {
        L721_AccountsMerge l721AccountsMerge = new L721_AccountsMerge();
        List<List<String>> accounts = Lists.newArrayList();
        accounts.add(Lists.newArrayList("David", "David0@m.co", "David1@m.co"));
        accounts.add(Lists.newArrayList("David", "David3@m.co", "David4@m.co"));
        accounts.add(Lists.newArrayList("David", "David4@m.co", "David5@m.co"));
        accounts.add(Lists.newArrayList("David", "David2@m.co", "David3@m.co"));
        accounts.add(Lists.newArrayList("David", "David1@m.co", "David2@m.co"));
        System.out.println(l721AccountsMerge.accountsMerge(accounts));
    }

    public class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            this.parent = new int[size];
            for (int i = 0; i < this.parent.length; i++) {
                this.parent[i] = i;
            }
        }

        public void union(int a, int b) {
            parent[find(a)] = find(b);
        }

        public int find(int a) {
            if (parent[a] == a) {
                return a;
            }
            return parent[a] = find(parent[a]);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> email2Id = new HashMap<>();
        UnionFind unionFind = new UnionFind(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            List<String> accountList = accounts.get(i);
            for (int j = 1; j < accountList.size(); j++) {
                String email = accountList.get(j);
                if (email2Id.containsKey(email)) {
                    //说明这个email 是存在过的，可以合并
                    unionFind.union(i, email2Id.get(email));
                } else {
                    //说明这email不存在
                    email2Id.put(email, i);
                }
            }
        }
        //这个时候，我们就知道了 accounts 每个节点的链接情况
        Set<String>[] temp = new Set[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            int parent = unionFind.find(i);
            Set<String> set = temp[parent] == null ? new TreeSet<>() : temp[parent];
            List<String> subList = accounts.get(i).subList(1, accounts.get(i).size());
            set.addAll(subList);
            temp[i] = set;
            temp[parent] = set;
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            if (unionFind.find(i) == i) {
                List<String> e = new ArrayList<>();
                e.add(accounts.get(i).get(0));
                e.addAll(temp[i]);
                result.add(e);
            }
        }
        return result;
    }
}
