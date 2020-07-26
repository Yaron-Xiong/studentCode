package com.accompnay.work.A2;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;
import java.util.Map;

public class ZoneXMLWriter extends ZoneWriter {

    private static final String islandSimpleString = "<zone name=\"%s\" serverIndex=\"%s\" capacity=\"%s\"/>";
    private Map<String, Domain> domainMap;

    public ZoneXMLWriter(Map<String, Domain> domainMap) {
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

        writer.write("<root>");
        writer.newLine();

        writeServers(zoneList, writer);
        writer.newLine();

        writeZones(writer, zoneIslandsList);
        writer.newLine();

        writer.write("</root>");
    }

    private void writeZones(BufferedWriter writer, List<List<Islands>> zoneIslands) throws IOException {
        writer.write("\t<zones>");
        writer.newLine();
        for (int i = 0; i < zoneIslands.size(); i++) {
            List<Islands> islandsList = zoneIslands.get(i);
            for (Islands islands : islandsList) {
                if (islands.getName().startsWith("$")) {
                    continue;
                }
                writer.write("\t\t" + String.format(islandSimpleString
                        , islands.getName()
                        , i + 1
                        , getCapacity(islands.getCurNum(), islands.getMaxNum())));
                writer.newLine();
            }
        }
        writer.write("\t</zones>");
    }

    private void writeServers(List<Zone> zoneList, BufferedWriter writer) throws IOException {
        writer.write("\t<servers>");
        writer.newLine();
        for (Zone zone : zoneList) {
            String ipOrDomainName = zone.getIp();
            Domain domain = domainMap.get(zone.getIp());
            if (domain != null) {
                ipOrDomainName = domain.getFlag() ? domain.getDomain() : ipOrDomainName;
            }
            writer.write("\t\t<server>" + ipOrDomainName + "/" + zone.getPort() + "</server>");
            writer.newLine();
        }
        writer.write("\t</servers>");
    }

}
