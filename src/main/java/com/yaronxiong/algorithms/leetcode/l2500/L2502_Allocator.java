package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2502. 设计内存分配器
 * 算术评级: 4
 * 第 323 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1746
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示下标从 0 开始的内存数组的大小。所有内存单元开始都是空闲的。
 * <p>
 * 请你设计一个具备以下功能的内存分配器：
 * <p>
 * 分配 一块大小为 size 的连续空闲内存单元并赋 id mID 。
 * 释放 给定 id mID 对应的所有内存单元。
 * 注意：
 * <p>
 * 多个块可以被分配到同一个 mID 。
 * 你必须释放 mID 对应的所有内存单元，即便这些内存单元被分配在不同的块中。
 * 实现 Allocator 类：
 * <p>
 * Allocator(int n) 使用一个大小为 n 的内存数组初始化 Allocator 对象。
 * int allocate(int size, int mID) 找出大小为 size 个连续空闲内存单元且位于  最左侧 的块，分配并赋 id mID 。返回块的第一个下标。如果不存在这样的块，返回 -1 。
 * int freeMemory(int mID) 释放 id mID 对应的所有内存单元。返回释放的内存单元数目。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Allocator", "allocate", "allocate", "allocate", "freeMemory", "allocate", "allocate", "allocate", "freeMemory", "allocate", "freeMemory"]
 * [[10], [1, 1], [1, 2], [1, 3], [2], [3, 4], [1, 1], [1, 1], [1], [10, 2], [7]]
 * 输出
 * [null, 0, 1, 2, 1, 3, 1, 6, 3, -1, 0]
 * <p>
 * 解释
 * Allocator loc = new Allocator(10); // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。
 * loc.allocate(1, 1); // 最左侧的块的第一个下标是 0 。内存数组变为 [1, , , , , , , , , ]。返回 0 。
 * loc.allocate(1, 2); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
 * loc.allocate(1, 3); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
 * loc.freeMemory(2); // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
 * loc.allocate(3, 4); // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
 * loc.allocate(1, 1); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
 * loc.allocate(1, 1); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
 * loc.freeMemory(1); // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
 * loc.allocate(10, 2); // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
 * loc.freeMemory(7); // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, size, mID <= 1000
 * 最多调用 allocate 和 free 方法 1000 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/design-memory-allocator/description/?envType=daily-question&envId=2025-02-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2502_Allocator {
    public static void main(String[] args) {
        Allocator allocator = new Allocator(7);
        System.out.println(allocator.allocate(3, 1));
        System.out.println(allocator.allocate(5, 2));
        System.out.println(allocator.freeMemory(1));
        System.out.println(allocator.freeMemory(3));
    }

    static class Allocator {
        private boolean[] arr;
        private Map<Integer, List<int[]>> mIdMap;

        public Allocator(int n) {
            arr = new boolean[n];
            mIdMap = new HashMap<>();
        }

        public int allocate(int size, int mID) {
            //找到能满足size的区间
            int availableSize = 0;
            int preIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]) {
                    preIndex = i;
                    availableSize = 0;
                    continue;
                }
                availableSize++;
                if (availableSize == size) {
                    //那么可用区间找到了 (preIndex,i]
                    Arrays.fill(arr, preIndex + 1, i + 1, true);
                    mIdMap.computeIfAbsent(mID, k -> new ArrayList<>()).add(new int[]{preIndex + 1, size});
                    return preIndex + 1;
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            List<int[]> indexAndSize = mIdMap.remove(mID);
            if (indexAndSize == null) {
                return 0;
            }
            int ans = 0;
            for (int[] ints : indexAndSize) {
                //那么可用区间找到了 (preIndex,i]
                Arrays.fill(arr, ints[0], ints[0] + ints[1], false);
                ans += ints[1];
            }
            return ans;
        }
    }
}
