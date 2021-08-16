package com.accompnay.hacking;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
public class ChangeLog extends BaseBean {
	private static final String LOG_PATTERN = "(?<time>.*)change password: duoduoId:(?<duoduoId>.*), type:(?<type>.*), ip:(?<ip>\\S*), ua:(?<ua>.*), gameId:(?<gameId>.*), gameName(?<gameName>.*), ext:(?<ext>.*), result:(?<result>.*)";
	private static final Pattern PATTERN = Pattern.compile(LOG_PATTERN);
	public static final ChangeLog NULL_LOG = new ChangeLog();
	private String duoduoId;
	private String type;
	private String ip;
	private String ua;
	private String gameId;
	private String gameName;
	public String ext;
	public String result;
	public String time;

	public ChangeLog(String duoduoId, String type, String ip, String ua, String gameId, String gameName, String ext, String result, String time) {
		setDuoduoId(duoduoId);
		this.type = type;
		this.ip = ip;
		this.ua = ua;
		this.gameId = gameId;
		this.gameName = gameName;
		this.ext = ext;
		this.result = result;
		this.time = time;
	}

	public static Function<String, ChangeLog> getResolveFunction() {
		return new Function<String, ChangeLog>() {
			@Nullable
			@Override
			public ChangeLog apply(@Nullable String line) {
				Matcher matcher = PATTERN.matcher(line);
				if (matcher.find()) {
					String duoduoId = matcher.group("duoduoId");
					String type = matcher.group("type");
					String ip = matcher.group("ip");
					String ua = matcher.group("ua");
					String gameId = matcher.group("gameId");
					String gameName = matcher.group("gameName");
					String ext = matcher.group("ext");
					String result = matcher.group("result");
					String time = matcher.group("time");
					return new ChangeLog(duoduoId, type, ip, ua, gameId, gameName, ext, result, time);
				}
				return NULL_LOG;
			}
		};
	}


}
