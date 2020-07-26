package com.accompnay.work.A2;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Map;

public class Main {

	private static final String zoneFilePath = "zone.config.txt";
	private static final String domainFilePath = "domain.txt";

    public static void main(String[] args) throws Exception {
        long readStart = System.currentTimeMillis();
        Map<String, Zone> zoneMap = ZoneRead.read(zoneFilePath);
        Map<String, Domain> domainMap = DomainRead.read(domainFilePath);
        long readEnd = System.currentTimeMillis();
		ZoneWriter zoneWriter = ZoneWriterFactory.getZoneWriter(args, domainMap);
		String outputFilePath;
        if (Sets.newHashSet(args).contains("json")) {
            outputFilePath = "src/main/resources/zoneXML.json";
        } else {
            outputFilePath = "src/main/resources/zoneXML.txt";
        }
        zoneWriter.write(zoneMap, outputFilePath);
        System.out.println(String.format("reader = file , read time = %s ms", readEnd - readStart));
    }


}
