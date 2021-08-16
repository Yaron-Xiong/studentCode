package com.accompnay.hacking;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
public class NginxLog extends BaseBean {
	private static final String LOG_PATTERN = ".*:(?<remoteAddr>\\S*) -.*- \\[(?<time>.*)\\] \"(?<request>.*)\" 200 \\S* \"(?<url>.*)\" x00 \"(?<xForwardedFor>\\S*)\" .*";
	private static final String DDID_PATTERN_STR = "\\S*duoduoId=(?<duoduoId>\\S*)&.*";
	private static final Pattern PATTERN = Pattern.compile(LOG_PATTERN);
	private static final Pattern DDID_PATTERN = Pattern.compile(DDID_PATTERN_STR);
	public static final NginxLog NULL_LOG = new NginxLog();
	private String remoteAddr;
	private String xForwardedFor;
	private String time;
	private String request;
	private String url;

	public NginxLog(String remoteAddr, String xForwardedFor, String time, String request, String url, String duoduoId) {
		this.remoteAddr = remoteAddr;
		this.xForwardedFor = xForwardedFor;
		this.time = time;
		//this.request = request;
		//this.url = url;
		setDuoduoId(duoduoId);
	}

	public static Function<String, NginxLog> getResolveFunction() {
		return new Function<String, NginxLog>() {
			@Nullable
			@Override
			public NginxLog apply(@Nullable String line) {
				Matcher matcher = PATTERN.matcher(line);
				if (matcher.find()) {
					String remoteAddr = matcher.group("remoteAddr");
					String time = matcher.group("time");
					String request = matcher.group("request");
					String url = matcher.group("url");
					String xForwardedFor = matcher.group("xForwardedFor");
					Matcher duoduoIdMather = DDID_PATTERN.matcher(url);
					String duoduoId = null;
					if (duoduoIdMather.find()) {
						duoduoId = duoduoIdMather.group("duoduoId");
					}
					return new NginxLog(remoteAddr, xForwardedFor, time, request, url, duoduoId);
				}
				return NULL_LOG;
			}
		};
	}

	@Override
	public String toString() {
		return "NginxLog{" +
				"remoteAddr='" + remoteAddr + '\'' +
				", xForwardedFor='" + xForwardedFor + '\'' +
				", time='" + time + '\'' +
				", request='" + request + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
