package com.accompnay.work.A2;

import org.apache.poi.ss.formula.functions.T;

import java.io.BufferedWriter;
import java.io.IOException;
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

    protected int getCapacity(int curNum, int maxNum) {
        double p = (double) curNum / maxNum;
        if (p < 0.1) {
            return 1;
        } else if (0.1 <= p && p < 0.3) {
            return 2;
        } else if (0.3 <= p && p < 0.4) {
            return 3;
        } else if (0.4 <= p && p < 0.5) {
            return 4;
        } else if (0.5 <= p && p < 0.7) {
            return 5;
        } else if (0.7 <= p && p < 0.8) {
            return 6;
        } else if (0.8 <= p) {
            return 7;
        }
        return 0;
    }
}
