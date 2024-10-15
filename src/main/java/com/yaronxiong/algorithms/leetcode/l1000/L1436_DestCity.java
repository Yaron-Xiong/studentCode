package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.*;

/**
 * 1436. 旅行终点站
 * 算术评级: 3
 * 第 187 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1192
 * 相关标签
 * 相关企业
 * 提示
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，
 * 其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。
 * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * <p>
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 * <p>
 * 示例 1：
 * <p>
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * 示例 2：
 * <p>
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * 显然，旅行终点站是 "A" 。
 * 示例 3：
 * <p>
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 * <p>
 * 提示：
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * 所有字符串均由大小写英文字母和空格字符组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/destination-city/description/?envType=daily-question&envId=2024-10-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1436_DestCity {
    public String destCity(List<List<String>> paths) {
        Set<String> outSet = new HashSet<>();
        for (List<String> path : paths) {
            outSet.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!outSet.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
