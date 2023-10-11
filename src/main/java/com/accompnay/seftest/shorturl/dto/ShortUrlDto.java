package com.accompnay.seftest.shorturl.dto;

import java.util.Date;

public class ShortUrlDto {
    private Long id;
    private String shortUrlDomain;
    private String shortUrl;
    private String longUrl;
    private ShortUrlStatus status;
    private Date creatTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrlDomain() {
        return shortUrlDomain;
    }

    public void setShortUrlDomain(String shortUrlDomain) {
        this.shortUrlDomain = shortUrlDomain;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
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

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
