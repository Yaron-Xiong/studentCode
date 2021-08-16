package com.accompnay.hacking;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
public class BindLog extends BaseBean {
	private static final String LOG_PATTERN = "(?<time>.*)bind , duoduoId:(?<duoduoId>[0-9]*), type:(?<type>\\S*), ip:(?<ip>\\S*), ext:(?<ext>\\S*), ua:(?<ua>.*), result:(?<result>.*)";
	private static final Pattern PATTERN = Pattern.compile(LOG_PATTERN);
	public static final BindLog NULL_LOG = new BindLog();
	private String type;
	private String ip;
	private String ua;
	private String result;
	private String ext;
	private String time;
	public String duoduoId;

	public BindLog(String duoduoId, String type, String ip, String ua, String result, String ext, String time) {
		setDuoduoId(duoduoId);
		this.type = type;
		this.ip = ip;
		this.ua = ua;
		this.result = result;
		this.ext = ext;
		this.time = time;
	}

	public static Function<String, BindLog> getResolveFunction() {
		return new Function<String, BindLog>() {
			@Nullable
			@Override
			public BindLog apply(@Nullable String line) {
				Matcher matcher = PATTERN.matcher(line);
				if (matcher.find()) {
					String duoduoId = matcher.group("duoduoId");
					String type = matcher.group("type");
					String ip = matcher.group("ip");
					String ua = matcher.group("ua");
					String result = matcher.group("result");
					String ext = matcher.group("ext");
					String time = matcher.group("time");
					return new BindLog(duoduoId, type, ip, ua, result, ext,time);
				}
				return NULL_LOG;
			}
		};
	}
}
