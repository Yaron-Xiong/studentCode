package com.accompnay.hacking;

import com.google.common.base.Objects;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.function.Function;

@Data
public class ResetPwd extends BaseBean{


	private String type;
	private String game;
	private String ip;
	private String date;
	public String duoduoId;

	public ResetPwd(String duoduoId,String type, String game, String ip, String date) {
		setDuoduoId(duoduoId);
		this.type = type;
		this.game = game;
		this.ip = ip;
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ResetPwd resetPwd = (ResetPwd) o;
		return Objects.equal(getDuoduoId(), resetPwd.getDuoduoId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getDuoduoId());
	}


	public static Function<String, @Nullable ResetPwd> getResolveFunction() {
		return new Function<String, ResetPwd>() {
			@Nullable
			@Override
			public ResetPwd apply(@Nullable String line) {
				String[] split = line.split("\t");
				String[] timeAndDDId = split[0].split(" ");
				String duoduoId = timeAndDDId[2];
				String type = split[1];
				String game = split[2];
				String ip = split[3];
				String time = timeAndDDId[0] + " " + timeAndDDId[1];
				return new ResetPwd(duoduoId, type, game, ip, time);
			}
		};
	}
}
