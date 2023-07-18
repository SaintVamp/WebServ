package com.svt.entity.tool;


import com.alibaba.fastjson.annotation.JSONField;

public class StartRequest {
	private int AppId;
	private int IsRedFinger;
	private int TemplateFileId;
	private long AppVersion;
	private long ClientTimestamp;
	private String RegCode;
	private String AppInfo;
	private String DeviceCode;
	private String DeviceId;
	private String TemplateVersion;

	@JSONField(name = "ClientTimestamp")
	public long getClientTimestamp ( ) {
		return ClientTimestamp;
	}

	@JSONField(name = "AppVersion")
	public long getAppVersion ( ) {
		return AppVersion;
	}

	@JSONField(name = "AppId")
	public int getAppId ( ) {
		return AppId;
	}

	@JSONField(name = "IsRedFinger")
	public int getIsRedFinger ( ) {
		return IsRedFinger;
	}

	@JSONField(name = "TemplateFileId")
	public int getTemplateFileId ( ) {
		return TemplateFileId;
	}

	@JSONField(name = "AppInfo")
	public String getAppInfo ( ) {
		return AppInfo;
	}

	@JSONField(name = "DeviceCode")
	public String getDeviceCode ( ) {
		return DeviceCode;
	}

	@JSONField(name = "DeviceId")
	public String getDeviceId ( ) {
		return DeviceId;
	}

	@JSONField(name = "RegCode")
	public String getRegCode ( ) {
		return RegCode;
	}

	@JSONField(name = "TemplateVersion")
	public String getTemplateVersion ( ) {
		return TemplateVersion;
	}

	public void setClientTimestamp ( long clientTimestamp ) {
		ClientTimestamp = clientTimestamp;
	}

	public void setAppVersion ( long appVersion ) {
		AppVersion = appVersion;
	}

	public void setAppId ( int appId ) {
		AppId = appId;
	}

	public void setIsRedFinger ( int isRedFinger ) {
		IsRedFinger = isRedFinger;
	}

	public void setTemplateFileId ( int templateFileId ) {
		TemplateFileId = templateFileId;
	}

	public void setAppInfo ( String appInfo ) {
		AppInfo = appInfo;
	}

	public void setDeviceCode ( String deviceCode ) {
		DeviceCode = deviceCode;
	}

	public void setDeviceId ( String deviceId ) {
		DeviceId = deviceId;
	}

	public void setRegCode ( String regCode ) {
		RegCode = regCode;
	}

	public void setTemplateVersion ( String templateVersion ) {
		TemplateVersion = templateVersion;
	}
}
