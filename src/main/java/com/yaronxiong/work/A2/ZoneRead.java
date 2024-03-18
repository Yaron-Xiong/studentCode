package com.yaronxiong.work.A2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZoneRead {

    public static Map<String, Zone> read(String filePath) throws IOException {
        Map<String, Zone> zoneMap = new HashMap<>();
        try (BufferedReader reader = IOUtils.getBufferedReader(filePath)) {
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                String[] split = readLine.split("\\s+");
                String ip = split[1];
                String port = split[2];
                String key = ip + ":" + port;
                Zone zone = zoneMap.getOrDefault(key, new Zone(ip, Integer.valueOf(port)));
                String name = split[0];
                String curNum = split[3];
                String maxNum = split[4];
                Islands islands = new Islands(name, curNum, maxNum);
                zone.addIslands(islands);
                zoneMap.put(key, zone);
            }
        }
        return zoneMap;
    }
}
