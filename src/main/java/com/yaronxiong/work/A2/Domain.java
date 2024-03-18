package com.yaronxiong.work.A2;

public class Domain {
    private String ip;
    private String domain;
    private boolean flag;

    public Domain(String ip, String domain, String flag) {
        this.ip = ip;
        this.domain = domain;
        this.flag = Integer.parseInt(flag) == 1 ;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
