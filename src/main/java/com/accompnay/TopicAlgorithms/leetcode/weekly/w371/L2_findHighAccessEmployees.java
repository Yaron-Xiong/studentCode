package com.accompnay.TopicAlgorithms.leetcode.weekly.w371;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L2_findHighAccessEmployees {
    public static void main(String[] args) {
        L2_findHighAccessEmployees l2FindHighAccessEmployees = new L2_findHighAccessEmployees();
        ArrayList<List<String>> accessTimes = new ArrayList<>();
        //[["cntkzpvavb","1118"],["fhejjadcp","1237"],["ob","1214"],["bpzmtbuj","1210"],["bjcjw","1234"],
        // ["bjcjw","1105"],["bpzmtbuj","1106"],
        // ["bpzmtbuj","1144"],["ob","1201"],["bpzmtbuj","1255"],["ipm","1200"],["ipm","1138"]]
        accessTimes.add(Lists.newArrayList("cntkzpvavb","1118"));
        accessTimes.add(Lists.newArrayList("fhejjadcp","1237"));
        accessTimes.add(Lists.newArrayList("ob","1214"));
        accessTimes.add(Lists.newArrayList("bpzmtbuj","1210"));
        accessTimes.add(Lists.newArrayList("bjcjw","1234"));
        accessTimes.add(Lists.newArrayList("bjcjw","1105"));
        accessTimes.add(Lists.newArrayList("bpzmtbuj","1106"));
        accessTimes.add(Lists.newArrayList("bpzmtbuj","1144"));
        accessTimes.add(Lists.newArrayList("ob","1201"));
        accessTimes.add(Lists.newArrayList("bpzmtbuj","1255"));
        accessTimes.add(Lists.newArrayList("ipm","1200"));
        accessTimes.add(Lists.newArrayList("ipm","1138"));
        System.out.println(l2FindHighAccessEmployees.findHighAccessEmployees(accessTimes));
    }

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<String>> nameTimes = new HashMap<>();
        for (List<String> accessTime : access_times) {
            String name = accessTime.get(0);
            String time = accessTime.get(1);
            List<String> times = nameTimes.computeIfAbsent(name, (a) -> new ArrayList<>());
            times.add(time);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : nameTimes.entrySet()) {
            if (entry.getValue().size() < 3) {
                continue;
            }
            List<String> times = entry.getValue();
            times.sort(String::compareTo);
            boolean isT = false;
            for (int i = 0; i < times.size(); i++) {
                String startTime = times.get(i);
                Integer h = Integer.parseInt(startTime.substring(0, 2)) + 1;
                String endTime;
                if (h == 24) {
                    endTime = "2400";
                } else {
                    String hs = String.valueOf(h);
                    if (h < 10) {
                        hs = "0" + h;
                    }
                    endTime = hs + startTime.substring(2);
                }
                int count = 1;
                for (int j = i + 1; j < times.size(); j++) {
                    if (times.get(j).compareTo(endTime) < 0) {
                        count++;
                    }
                }
                if (count >= 3) {
                    isT = true;
                    break;
                }
            }
            if (isT) {
                ans.add(entry.getKey());
            }
        }
        return ans;

    }
}
