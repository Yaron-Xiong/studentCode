package com.accompnay.nginx;

import java.io.Serializable;

public class UrlMessage implements Serializable {
	private String url;
	private Integer useCount;
	private Double avgResponseTime;
	private Double rateSuccess;
	private Integer successfulTimes;

	public Integer getSuccessfulTimes() {
		return successfulTimes;
	}

	public void setSuccessfulTimes(Integer successfulTimes) {
		this.successfulTimes = successfulTimes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUseCount() {
		return useCount;
	}

	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

	public Double getAvgResponseTime() {
		return avgResponseTime;
	}

	public void setAvgResponseTime(Double avgResponseTime) {
		this.avgResponseTime = avgResponseTime;
	}

	public Double getRateSuccess() {
		return rateSuccess;
	}

	public void setRateSuccess(Double rateSuccess) {
		this.rateSuccess = rateSuccess;
	}

	@Override
	public String toString() {
		return "UrlMessage{" +
				"url='" + url + '\'' +
				", useCount=" + useCount +
				", avgResponseTime=" + avgResponseTime +
				", rateSuccess=" + rateSuccess +
				", successfulTimes=" + successfulTimes +
				'}';
	}
}
