package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.*;

/**
 * 2007. 从双倍数组中还原原数组
 * 算术评级: 5
 * 第 61 场双周赛
 * Q2
 * 1557
 * 相关标签
 * 相关企业
 * 提示
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * <p>
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：changed = [1,3,4,2,6,8]
 * 输出：[1,3,4]
 * 解释：一个可能的 original 数组为 [1,3,4] :
 * - 将 1 乘以 2 ，得到 1 * 2 = 2 。
 * - 将 3 乘以 2 ，得到 3 * 2 = 6 。
 * - 将 4 乘以 2 ，得到 4 * 2 = 8 。
 * 其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
 * 示例 2：
 * <p>
 * 输入：changed = [6,3,0,1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * 示例 3：
 * <p>
 * 输入：changed = [1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * <p>
 * 提示：
 * <p>
 * 1 <= changed.length <= 105
 * 0 <= changed[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-original-array-from-doubled-array/description/?envType=daily-question&envId=2024-04-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2007_FindOriginalArray {
    public static void main(String[] args) {
        L2007_FindOriginalArray l2007FindOriginalArray = new L2007_FindOriginalArray();
        System.out.println(Arrays.toString(l2007FindOriginalArray.findOriginalArray(new int[]{4,2,0})));
    }

    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, Integer> numberCntMap = new HashMap<>();
        for (int i : changed) {
            numberCntMap.merge(i, 1, Integer::sum);
        }
        List<Integer> originList = new ArrayList<>();
        for (int originValue : changed) {
            if (!numberCntMap.containsKey(originValue)) {
                continue;
            }
            //当前节点作为origin
            int originCnt = numberCntMap.get(originValue);
            int changeValue = originValue * 2;
            if (!numberCntMap.containsKey(changeValue) || numberCntMap.get(changeValue) < originCnt) {
                //不满足条件
                return new int[0];
            }
            int originLength;
            if (originValue == changeValue) {
                originLength = originCnt / 2;
                if (originLength == 0) {
                    return new int[0];
                }
            } else {
                originLength = originCnt;
                numberCntMap.compute(changeValue, (key, oldValue) -> oldValue - originCnt);
                if (numberCntMap.get(changeValue) == 0) {
                    numberCntMap.remove(changeValue);
                }
            }
            for (int i = 0; i < originLength; i++) {
                originList.add(originValue);
            }
            numberCntMap.remove(originValue);
        }
        int[] result = new int[originList.size()];
        for (int i = 0; i < originList.size(); i++) {
            result[i] = originList.get(i);
        }
        return result;
    }
}
