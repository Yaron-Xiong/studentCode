package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 1146. 快照数组
 * 算术评级: 7
 * 第 148 场周赛
 * Q3
 * 1771
 * 相关标签
 * 相关企业
 * 提示
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 * <p>
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 * <p>
 * 示例：
 * <p>
 * 输入：["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * 输出：[null,null,0,null,5]
 * 解释：
 * SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
 * snapshotArr.set(0,5);  // 令 array[0] = 5
 * snapshotArr.snap();  // 获取快照，返回 snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
 * <p>
 * 提示：
 * <p>
 * 1 <= length <= 50000
 * 题目最多进行50000 次set，snap，和 get的调用 。
 * 0 <= index < length
 * 0 <= snap_id < 我们调用 snap() 的总次数
 * 0 <= val <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/snapshot-array/description/?envType=daily-question&envId=2024-04-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1146_SnapshotArray {
    public static void main(String[] args) {
        L1146_SnapshotArray.SnapshotArray l1146SnapshotArray = new L1146_SnapshotArray.SnapshotArray(3);
        l1146SnapshotArray.set(1, 18);
        l1146SnapshotArray.set(1, 4);
        l1146SnapshotArray.snap(); // 1->4
        System.out.println(l1146SnapshotArray.get(0, 0));
        l1146SnapshotArray.set(0, 20); //0snap: 1->4 | 1snap: 0->20 , 1->4
        l1146SnapshotArray.snap();
        l1146SnapshotArray.set(0, 2); //0snap: 1->4 | 1snap: 0->20 , 1->4 | 2snap 0->2,1->4
        l1146SnapshotArray.set(1, 1); //0snap: 1->4 | 1snap: 0->20 , 1->4 | 2snap 0->2,1->1
        System.out.println(l1146SnapshotArray.get(1, 1));
        System.out.println(l1146SnapshotArray.get(1, 0));
    }

    static class Node {
        TreeMap<Integer, Integer> snapMap = new TreeMap<>();

        public Node() {
            snapMap.put(-1, 0);
        }

        public void setValue(int snap, int val) {
            snapMap.put(snap, val);
        }

        public int get(int snap) {
            if (snapMap.containsKey(snap)) {
                return snapMap.get(snap);
            }
            Integer key = snapMap.lowerKey(snap);
            return snapMap.getOrDefault(key, 0);
        }
    }

    static class SnapshotArray {
        private int snap;
        private Node[] arr;

        public SnapshotArray(int length) {
            arr = new Node[length];
            Arrays.setAll(arr, i -> new Node());
            snap = 0;
        }

        public void set(int index, int val) {
            arr[index].setValue(snap, val);
        }

        public int snap() {
            snap++;
            return snap - 1;
        }

        public int get(int index, int snap_id) {
            return arr[index].get(snap_id);
        }
    }
}
