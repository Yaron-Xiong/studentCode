package com.accompnay.nginx;

import java.util.Date;

public class LogEntity {
	private String ip;
	private Date time;
	/**
	 * 请求方式
	 */
	private String request;
	private String url;
	private String protocol;
	private Integer responseCode;
	private Integer sendBytes;
	private String refferer;
	private String XforwardedFor;
	private String userAgent;
	private Double requestTime;
	private Double responseTime;
	private String host;
	private String upstreamAddr;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public Integer getSendBytes() {
		return sendBytes;
	}

	public void setSendBytes(Integer sendBytes) {
		this.sendBytes = sendBytes;
	}

	public String getRefferer() {
		return refferer;
	}

	public void setRefferer(String refferer) {
		this.refferer = refferer;
	}

	public String getXforwardedFor() {
		return XforwardedFor;
	}

	public void setXforwardedFor(String xforwardedFor) {
		XforwardedFor = xforwardedFor;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Double getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Double requestTime) {
		this.requestTime = requestTime;
	}

	public Double getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Double responseTime) {
		this.responseTime = responseTime;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUpstreamAddr() {
		return upstreamAddr;
	}

	public void setUpstreamAddr(String upstreamAddr) {
		this.upstreamAddr = upstreamAddr;
	}


}
