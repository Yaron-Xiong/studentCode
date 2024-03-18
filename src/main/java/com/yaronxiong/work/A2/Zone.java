package com.yaronxiong.work.A2;

import java.util.ArrayList;
import java.util.List;

public class Zone {
	private String ip;
	private Integer port;
	private List<Islands> islandsList;

	public Zone(String ip,Integer port) {
		this.ip = ip;
		this.port = port;
		this.islandsList = new ArrayList<>();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public List<Islands> getIslandsList() {
		return islandsList;
	}

	public void addIslands(Islands islands){
		islandsList.add(islands);
	}
}
