package com.yaronxiong.work.A2;

import java.io.BufferedWriter;
import java.util.Map;

public abstract class ZoneWriter {

    public void write(Map<String, Zone> zoneMap, String outputFilePath) {
        try (BufferedWriter writer = IOUtils.getBufferWriter(outputFilePath)) {
            write(zoneMap, writer);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void write(Map<String, Zone> zoneMap, BufferedWriter writer) throws Exception;

    private static int[] capacityList = new int[]{1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7};

    protected int getCapacity(int curNum, int maxNum) {
        double p = (double) curNum / maxNum;
        int index = (int) (p * 10);
        return capacityList[index];
    }
}
