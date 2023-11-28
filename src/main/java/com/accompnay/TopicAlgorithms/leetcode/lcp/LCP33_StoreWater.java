package com.accompnay.TopicAlgorithms.leetcode.lcp;

import java.util.Arrays;

/**
 * LCP 33. 蓄水
 * 简单
 * 187
 * 相关企业
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 * <p>
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 * <p>
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bucket = [1,3], vat = [6,8]
 * <p>
 * 输出：4
 * <p>
 * 解释： 第 1 次操作升级 bucket[0]； 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。vat1.gif
 * <p>
 * 示例 2：
 * <p>
 * 输入：bucket = [9,0,1], vat = [0,2,2]
 * <p>
 * 输出：3
 * <p>
 * 解释： 第 1 次操作均选择升级 bucket[1] 第 2~3 次操作选择蓄水，即可完成蓄水要求。
 * <p>
 * 提示：
 * <p>
 * 1 <= bucket.length == vat.length <= 100
 * 0 <= bucket[i], vat[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/o8SXZn/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP33_StoreWater {
    public static void main(String[] args) {
        LCP33_StoreWater lcp33StoreWater = new LCP33_StoreWater();
        System.out.println(lcp33StoreWater.storeWater(new int[]{16, 29, 42, 70, 42, 9}, new int[]{89, 44, 50, 90, 94, 91}));
    }

    public int storeWater(int[] bucket, int[] vat) {
        //两个未知数，X：水桶升级次数 K：蓄水次数
        //假设将K固定，求X
        //那么最后结果为 Min(X+Y)
        int res = Integer.MAX_VALUE;
        int maxK = Arrays.stream(vat).max().getAsInt();
        if (maxK == 0) {
            return 0;
        }
        for (int k = 1; k <= maxK; k++) {
            int temp = k;
            //我要到达蓄水次数 i 那么我水桶需要升级多少次？ 才能够将水桶vat[i] 蓄满
            for (int i = 0; i < bucket.length && temp < res; i++) {
                if (vat[i] == 0) {
                    continue;
                }
                int cap = (int) Math.ceil((double) vat[i] / k);
                //桶需要提高的次数
                int diff = cap - bucket[i];
                if (diff < 0) {
                    continue;
                }
                temp += diff;
            }
            res = Math.min(res, temp);
        }
        return res;
    }
}
