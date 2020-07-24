package com.accompnay.work.A2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	private static final String encoding = "UTF-8";

	public static void main(String[] args) throws Exception {
		String filePath = "zone.config.txt";
		Map<String, Zone> zoneMap = getZoneMap(filePath);
		Set<String> strings = zoneMap.keySet();
		System.out.println(zoneMap);
	}

	private static Map<String, Zone> getZoneMap(String filePath) throws IOException {
		BufferedReader bufferedReader = getBufferedReader(filePath);
		String readLine;
		Map<String, Zone> zoneMap = new HashMap<>();
		while ((readLine = bufferedReader.readLine()) != null) {
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
		return zoneMap;
	}

	private static BufferedReader getBufferedReader(String filePath) throws UnsupportedEncodingException {
		InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath);
		assert inputStream != null;
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, encoding);
		return new BufferedReader(inputStreamReader);
	}
}
