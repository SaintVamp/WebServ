package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;

public class AppConfigRequest {
	private int ANDROID_DEVICE;
	private int DeviceType;
	private int AppId;
	private int IsRedFinger;
	private int TemplateFileId;
	private long ClientTimestamp;
	private String AppInfo;
	private String AppVersion;
	private String DeviceCode;
	private String DeviceId;
	private String TemplateVersion;


	@JSONField(name = "TemplateVersion")
	public String getTemplateVersion ( ) {
		return TemplateVersion;
	}

	@JSONField(name = "DeviceId")
	public String getDeviceId ( ) {
		return DeviceId;
	}

	@JSONField(name = "DeviceCode")
	public String getDeviceCode ( ) {
		return DeviceCode;
	}

	@JSONField(name = "AppInfo")
	public String getAppInfo ( ) {
		return AppInfo;
	}

	@JSONField(name = "AppVersion")
	public String getAppVersion ( ) {
		return AppVersion;
	}

	@JSONField(name = "ClientTimestamp")
	public long getClientTimestamp ( ) {
		return ClientTimestamp;
	}

	@JSONField(name = "TemplateFileId")
	public int getTemplateFileId ( ) {
		return TemplateFileId;
	}

	@JSONField(name = "IsRedFinger")
	public int getIsRedFinger ( ) {
		return IsRedFinger;
	}

	@JSONField(name = "AppId")
	public int getAppId ( ) {
		return AppId;
	}

	@JSONField(name = "ANDROID_DEVICE")
	public int getANDROID_DEVICE ( ) {
		return ANDROID_DEVICE;
	}

	@JSONField(name = "DeviceType")
	public int getDeviceType ( ) {
		return DeviceType;
	}

	public void setTemplateVersion ( String templateVersion ) {
		TemplateVersion = templateVersion;
	}

	public void setDeviceId ( String deviceId ) {
		DeviceId = deviceId;
	}

	public void setDeviceCode ( String deviceCode ) {
		DeviceCode = deviceCode;
	}

	public void setAppInfo ( String appInfo ) {
		AppInfo = appInfo;
	}

	public void setAppVersion ( String appVersion ) {
		AppVersion = appVersion;
	}

	public void setTemplateFileId ( int templateFileId ) {
		TemplateFileId = templateFileId;
	}

	public void setIsRedFinger ( int isRedFinger ) {
		IsRedFinger = isRedFinger;
	}

	public void setAppId ( int appId ) {
		AppId = appId;
	}

	public void setANDROID_DEVICE ( int ANDROID_DEVICE ) {
		this.ANDROID_DEVICE = ANDROID_DEVICE;
	}

	public void setDeviceType ( int deviceType ) {
		DeviceType = deviceType;
	}

	public void setClientTimestamp ( long clientTimestamp ) {
		ClientTimestamp = clientTimestamp;
	}
}
