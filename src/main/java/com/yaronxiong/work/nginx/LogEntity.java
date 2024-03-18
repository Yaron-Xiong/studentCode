package com.yaronxiong.work.nginx;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
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

}
