package com.accompnay.seftest.shorturl.dto;

public class ShortUrlConfig implements Cloneable {
    private String shortUrlDomainCode;
    private String longUrl;
    private ShortUrlStatus status = ShortUrlStatus.EFFECTIVE;

    @Override
    public ShortUrlConfig clone() {
        ShortUrlConfig shortUrlConfig = new ShortUrlConfig();
        shortUrlConfig.setShortUrlDomainCode(this.getShortUrlDomainCode());
        shortUrlConfig.setLongUrl(this.getLongUrl());
        shortUrlConfig.setStatus(this.getStatus());
        return shortUrlConfig;
    }

    public String getShortUrlDomainCode() {
        return shortUrlDomainCode;
    }

    public void setShortUrlDomainCode(String shortUrlDomainCode) {
        this.shortUrlDomainCode = shortUrlDomainCode;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public ShortUrlStatus getStatus() {
        return status;
    }

    public void setStatus(ShortUrlStatus status) {
        this.status = status;
    }
}
