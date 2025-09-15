package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.*;

/**
 * 1733. 需要教语言的最少人数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。
 * <p>
 * 给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下：
 * <p>
 * 总共有 n 种语言，编号从 1 到 n 。
 * languages[i] 是第 i 位用户掌握的语言集合。
 * friendships[i] = [ui, vi] 表示 ui 和 vi 为好友关系。
 * 你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。
 * <p>
 * 请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
 * 输出：1
 * 解释：你可以选择教用户 1 第二门语言，也可以选择教用户 2 第一门语言。
 * 示例 2：
 * <p>
 * 输入：n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
 * 输出：2
 * 解释：教用户 1 和用户 3 第三门语言，需要教 2 名用户。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 500
 * languages.length == m
 * 1 <= m <= 500
 * 1 <= languages[i].length <= n
 * 1 <= languages[i][j] <= n
 * 1 <= ui < vi <= languages.length
 * 1 <= friendships.length <= 500
 * 所有的好友关系 (ui, vi) 都是唯一的。
 * languages[i] 中包含的值互不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-people-to-teach/description/?envType=daily-question&envId=2025-09-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1733_MinimumTeachings {
    public static void main(String[] args) {
        L1733_MinimumTeachings l1733MinimumTeachings = new L1733_MinimumTeachings();
        System.out.println(l1733MinimumTeachings.minimumTeachings(3, new int[][]{{2}, {1, 3}, {1, 2}, {3}}, new int[][]{{1, 4}, {1, 2}, {3, 4}, {2, 3}}));
        System.out.println(l1733MinimumTeachings.minimumTeachings(2, new int[][]{{1}, {2}, {1, 2}}, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        boolean[][] leanLanguages = new boolean[languages.length][n + 1];
        for (int i = 0; i < languages.length; i++) {
            for (int l : languages[i]) {
                leanLanguages[i][l] = true;
            }
        }
        Map<Integer, Set<Integer>> friendMap = new HashMap<>();
        for (int[] friendship : friendships) {
            int a = friendship[0] - 1;
            int b = friendship[1] - 1;
            Set<Integer> aFriend = friendMap.getOrDefault(a, Collections.emptySet());
            Set<Integer> bFriend = friendMap.getOrDefault(b, Collections.emptySet());
            Set<Integer> newFriend = new HashSet<>();
            newFriend.addAll(aFriend);
            newFriend.addAll(bFriend);
            newFriend.add(a);
            newFriend.add(b);
            friendMap.put(a, newFriend);
            friendMap.put(b, newFriend);
        }

        int ans = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : friendMap.entrySet()) {
            entry.getValue().add(entry.getKey());
            Set<Integer> friendGroup = entry.getValue();
            //找到这个关系中需要学习的语言
            List<Integer>[] cnt = new List[n + 1];
            Arrays.setAll(cnt, i -> new ArrayList<>());
            int maxIndex = 0;
            for (Integer i : friendGroup) {
                boolean[] leanLanguage = leanLanguages[i];
                for (int j = 0; j < leanLanguage.length; j++) {
                    boolean b = leanLanguage[j];
                    if (b) {
                        cnt[j].add(i);
                    }
                    if (cnt[j].size() > cnt[maxIndex].size()) {
                        maxIndex = j;
                    }
                }
            }
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i].isEmpty()) {
                    continue;
                }
                if (cnt[i].size() == 1) {
                    //说明要学习语言了
                    ans++;
                    //让谁去学习呢
                    Integer needLeanFriend = cnt[i].get(0);
                    if (leanLanguages[needLeanFriend][maxIndex]) {
                        continue;
                    }
                    leanLanguages[needLeanFriend][maxIndex] = true;
                    break;
                }
            }
        }
        return ans;
    }
}
