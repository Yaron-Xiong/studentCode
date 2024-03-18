package com.yaronxiong.work.A2;

import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.util.Map;

public class DomainRead {
    public static Map<String, Domain> read(String filePath) throws Exception {
        Map<String, Domain> result = Maps.newHashMap();
        try (BufferedReader reader = IOUtils.getBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\s+");
                String ip = split[0];
                String domainName = split[1];
                String flag = split[2];
                Domain domain = new Domain(ip, domainName, flag);
                result.put(ip, domain);
            }
        }
        return result;
    }
}
