package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;

public class Start extends ResponseTime {
	private long ExpireTime;
	private long DailyTryTimes;
	private long OnceTryMinute;
	private String RunGuid;

	public Start ( long timestamp  ) {
		super(timestamp);
		this.ExpireTime = 353402272000L;
		this.DailyTryTimes = 0;
		this.OnceTryMinute = 0;
		this.RunGuid = "1234567890";
	}

	@JSONField(name = "DailyTryTimes")
	public long getDailyTryTimes ( ) {
		return DailyTryTimes;
	}

	@JSONField(name = "ExpireTime")
	public long getExpireTime ( ) {
		return ExpireTime;
	}

	@JSONField(name = "OnceTryMinute")
	public long getOnceTryMinute ( ) {
		return OnceTryMinute;
	}

	@JSONField(name = "RunGuid")
	public String getRunGuid ( ) {
		return RunGuid;
	}

	public void setDailyTryTimes ( long dailyTryTimes ) {
		DailyTryTimes = dailyTryTimes;
	}

	public void setExpireTime ( long expireTime ) {
		ExpireTime = expireTime;
	}

	public void setOnceTryMinute ( long onceTryMinute ) {
		OnceTryMinute = onceTryMinute;
	}

	public void setRunGuid ( String runGuid ) {
		RunGuid = runGuid;
	}
}
