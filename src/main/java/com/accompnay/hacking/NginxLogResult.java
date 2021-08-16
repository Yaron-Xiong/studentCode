package com.accompnay.hacking;

import lombok.Data;

import java.util.List;

@Data
public class NginxLogResult implements Comparable<NginxLogResult>{
	private String duduoId;
	private List<NginxLog> nginxLogList;

	@Override
	public int compareTo(NginxLogResult o) {
		return o.getNginxLogList().size() - this.nginxLogList.size();
	}

	@Override
	public String toString() {
		return "NginxLogResult{" +
				"ip='" + duduoId + '\'' +
				", nginxLogList=" + nginxLogList.size() +
				'}';
	}
}
