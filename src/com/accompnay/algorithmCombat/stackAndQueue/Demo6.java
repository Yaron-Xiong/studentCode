package com.accompnay.algorithmCombat.stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Accompany
 * <p>
 * LeetCode 692
 * <p>
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 *
 * 解法1：计算全部单词出现的次数，然后放进数组中进行排序（根据出现次数排序）
 *  时间复杂度 O(n*logn)
 *
 * 解决2：
 * 1.计算全部单词出现的次数
 * 2.放进优先级队列（队列只存放K个数字），从小到大排序
 * 3.最后将全部队列输出
 * 时间复杂度 O(NlogK)  -->N个数要调整
 */
public class Demo6 {
    /*public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        //计算出现次数
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> wordList = new ArrayList<>(map.keySet());
        wordList.sort((w1,w2)->
                map.get(w1).equals(map.get(w2))?w1.compareTo(w2):map.get(w2)-map.get(w1));
        return wordList.subList(0,k);
    }*/

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        //计算出现次数
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //利用树结构排序 最小的在上面
        PriorityQueue<String> queue = new PriorityQueue<>((w1, w2) ->
                map.get(w1).equals(map.get(w2)) ?w2.compareTo(w1):map.get(w1)-map.get(w2)
        );
        for (String s : map.keySet()) {
            queue.offer(s);
            //只维护k个最大值的队列，因为每次剔除最小值，最后就剩下K个最大值
            if (queue.size()>k) queue.poll();
        }
        List<String> rs = new ArrayList<>();
        while (!queue.isEmpty()) rs.add(queue.poll());
        //因为是从小到大排序，所以需要逆序
        Collections.reverse(rs);
        return rs;
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        List<String> list = demo6.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println(list);
    }
}
