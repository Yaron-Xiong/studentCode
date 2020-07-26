package com.accompnay.work.A2;

import com.google.common.collect.Lists;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ZoneJsonWriter extends ZoneWriter {
    private static final String serverPrint = "\t\t{\"ip\":\"%s\",\"port\":\"%s\"}";
    private static final String zonesPrint = "\t\t{\"name\":\"%s\",\"serverIndex\":\"%s\",\"capacity\":\"%s\"}";
    private Map<String, Domain> domainMap;

    public ZoneJsonWriter(Map<String, Domain> domainMap) {
        this.domainMap = domainMap;
    }

    @Override
    public void write(Map<String, Zone> zoneMap, BufferedWriter writer) throws Exception {
        List<Zone> zoneList = Lists.newArrayList();
        List<List<Islands>> zoneIslandsList = Lists.newArrayList();
        for (Map.Entry<String, Zone> zoneEntry : zoneMap.entrySet()) {
            Zone zone = zoneEntry.getValue();
            zoneList.add(zone);
            List<Islands> islandsList = zone.getIslandsList();
            zoneIslandsList.add(islandsList);
        }
        writeRoot(zoneList, zoneIslandsList, writer);
    }

    private void writeRoot(List<Zone> zoneList, List<List<Islands>> zoneIslandsList, BufferedWriter writer) throws IOException {

        writer.write("{");
        writer.newLine();

        writeServers(zoneList, writer);
        writer.write(",");
        writer.newLine();

        writeZones(writer, zoneIslandsList);
        writer.newLine();

        writer.write("}");
    }

    private void writeServers(List<Zone> zoneList, BufferedWriter writer) throws IOException {
        writer.write("\tservers:");
        writer.newLine();
        writer.write("\t[");
        writer.newLine();
        for (int i = 0; i < zoneList.size(); i++) {
            Zone zone = zoneList.get(i);
            String ipOrDomainName = zone.getIp();
            Domain domain = domainMap.get(zone.getIp());
            if (domain != null) {
                ipOrDomainName = domain.getFlag() ? domain.getDomain() : ipOrDomainName;
            }
            writer.write(String.format(serverPrint, ipOrDomainName, zone.getPort()));
            if (i++ != zoneList.size() - 1) {
                writer.write(",");
            }
            writer.newLine();
        }
        writer.write("\t]");
    }

    private void writeZones(BufferedWriter writer, List<List<Islands>> zoneIslandsList) throws IOException {
        writer.write("\tzones:");
        writer.newLine();
        writer.write("\t[");
        writer.newLine();
        for (int i = 0; i < zoneIslandsList.size(); i++) {
            List<Islands> islandsList = zoneIslandsList.get(i);
            for (int j = 0; j < islandsList.size(); j++) {
                Islands islands = islandsList.get(j);
                if (islands.getName().startsWith("$")) {
                    continue;
                }
                writer.write(String.format(zonesPrint, islands.getName(), i, getCapacity(islands.getCurNum(), islands.getMaxNum())));
                if (!(i == zoneIslandsList.size() - 1 && j == islandsList.size() - 1)) {
                    writer.write(",");
                }
                writer.newLine();
            }
        }
        writer.write("\t]");
    }

}
