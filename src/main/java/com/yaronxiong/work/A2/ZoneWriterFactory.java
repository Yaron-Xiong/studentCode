package com.yaronxiong.work.A2;

import com.google.common.collect.Sets;

import java.util.Map;

public class ZoneWriterFactory {
    public static ZoneWriter getZoneWriter(String[] args, Map<String, Domain> domainMap) {
        ZoneWriter writer;
        if (Sets.newHashSet(args).contains("json")) {
            writer = new ZoneJsonWriter(domainMap);
        } else {
            writer = new ZoneXMLWriter(domainMap);
        }
        return writer;
    }
}
