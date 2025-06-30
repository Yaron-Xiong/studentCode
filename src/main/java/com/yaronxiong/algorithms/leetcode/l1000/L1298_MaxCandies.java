package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1298. 你能从盒子里获得的最大糖果数
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：
 * <p>
 * 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
 * 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
 * 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
 * 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
 * 给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。
 * <p>
 * 请你按照上述规则，返回可以获得糖果的 最大数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
 * 输出：16
 * 解释：
 * 一开始你有盒子 0 。你将获得它里面的 7 个糖果和盒子 1 和 2。
 * 盒子 1 目前状态是关闭的，而且你还没有对应它的钥匙。所以你将会打开盒子 2 ，并得到里面的 4 个糖果和盒子 1 的钥匙。
 * 在盒子 1 中，你会获得 5 个糖果和盒子 3 ，但是你没法获得盒子 3 的钥匙所以盒子 3 会保持关闭状态。
 * 你总共可以获得的糖果数目 = 7 + 4 + 5 = 16 个。
 * 示例 2：
 * <p>
 * 输入：status = [1,0,0,0,0,0], candies = [1,1,1,1,1,1], keys = [[1,2,3,4,5],[],[],[],[],[]], containedBoxes = [[1,2,3,4,5],[],[],[],[],[]], initialBoxes = [0]
 * 输出：6
 * 解释：
 * 你一开始拥有盒子 0 。打开它你可以找到盒子 1,2,3,4,5 和它们对应的钥匙。
 * 打开这些盒子，你将获得所有盒子的糖果，所以总糖果数为 6 个。
 * 示例 3：
 * <p>
 * 输入：status = [1,1,1], candies = [100,1,100], keys = [[],[0,2],[]], containedBoxes = [[],[],[]], initialBoxes = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：status = [1], candies = [100], keys = [[]], containedBoxes = [[]], initialBoxes = []
 * 输出：0
 * 示例 5：
 * <p>
 * 输入：status = [1,1,1], candies = [2,3,2], keys = [[],[],[]], containedBoxes = [[],[],[]], initialBoxes = [2,1,0]
 * 输出：7
 * <p>
 * 提示：
 * <p>
 * 1 <= status.length <= 1000
 * status.length == candies.length == keys.length == containedBoxes.length == n
 * status[i] 要么是 0 要么是 1 。
 * 1 <= candies[i] <= 1000
 * 0 <= keys[i].length <= status.length
 * 0 <= keys[i][j] < status.length
 * keys[i] 中的值都是互不相同的。
 * 0 <= containedBoxes[i].length <= status.length
 * 0 <= containedBoxes[i][j] < status.length
 * containedBoxes[i] 中的值都是互不相同的。
 * 每个盒子最多被一个盒子包含。
 * 0 <= initialBoxes.length <= status.length
 * 0 <= initialBoxes[i] < status.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-candies-you-can-get-from-boxes/description/?envType=daily-question&envId=2025-06-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1298_MaxCandies {
    public static void main(String[] args) {
        L1298_MaxCandies l1298MaxCandies = new L1298_MaxCandies();
        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = {{}, {}, {}, {}};
        int[][] containedBoxes = {{1, 2}, {3}, {}, {}};
        int[] initialBoxes = {1, 2};
        int ans = l1298MaxCandies.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
        System.out.println(ans);
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        //当前拥有的钥匙Set
        int[] hasKeys = status;
        //当前可以打开的盒子
        boolean[] hasBox = new boolean[status.length];
        for (int initialBox : initialBoxes) {
            if (status[initialBox] == 1) {
                deque.addLast(initialBox);
            }else {
                hasBox[initialBox] = true;
            }
        }

        while (!deque.isEmpty()) {
            int curBox = deque.removeFirst();
            ans += candies[curBox];
            for (int key : keys[curBox]) {
                if (hasBox[key]) {
                    hasBox[key] = false;
                    deque.addLast(key);
                }
                hasKeys[key] = 1;
            }

            //当前的盒子关联了什么盒子
            for (int containedBox : containedBoxes[curBox]) {
                if (status[containedBox] == 1 || hasKeys[containedBox] == 1) {
                    deque.addLast(containedBox);
                    hasBox[containedBox] = false;
                } else {
                    hasBox[containedBox] = true;
                }
            }
        }
        return ans;
    }
}
