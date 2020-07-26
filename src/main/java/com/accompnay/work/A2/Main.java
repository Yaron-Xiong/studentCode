package com.accompnay.work.A2;

import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		String zoneFilePath = "zone.config.txt";
		String domainFilePath = "domain.txt";
		Map<String, Zone> zoneMap = ZoneRead.read(zoneFilePath);
		Map<String, Domain> domainMap = DomainRead.read(domainFilePath);
		ZoneWriter writer = new ZoneJsonWriter(domainMap);
		writer.write(zoneMap,"src/main/resources/zoneXML.txt");
	}

}
