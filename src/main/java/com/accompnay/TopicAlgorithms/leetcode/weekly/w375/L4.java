package com.accompnay.TopicAlgorithms.leetcode.weekly.w375;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class L4 {
    public static void main(String[] args) throws IOException {
        L4 l4 = new L4();
        List<String> strings = Files.readAllLines(Paths.get("C:\\Users\\Accompany\\Desktop", "a.txt"));
        String[] split = strings.get(0).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(l4.numberOfGoodPartitions(arr));
    }

    public int numberOfGoodPartitions(int[] nums) {
        //划分组
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, i});
            }
            map.get(nums[i])[1] = i;
        }
        List<int[]> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(a -> a[0]));
        //合并组
        List<int[]> newBounds = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            //看i能与多少个合并成一个新的
            int[] init = list.get(i);
            int[] newBound = new int[]{init[0], init[1]};
            int j = i;
            for (; j < list.size(); j++) {
                if (list.get(j)[0] > newBound[1]) {
                    break;
                }
                newBound[0] = Math.min(newBound[0], list.get(j)[0]);
                newBound[1] = Math.max(newBound[1], list.get(j)[1]);
            }
            i = j;
            newBounds.add(newBound);
        }
        return new BigInteger(String.valueOf(2))
                .pow(newBounds.size() - 1)
                .mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
