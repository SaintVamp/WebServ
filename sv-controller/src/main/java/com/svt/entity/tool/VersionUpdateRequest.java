package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;
public class VersionUpdateRequest {
	private int AppId;
	private int IsRedFinger;
	private int IsScriptHotUpgrade;
	private int TemplateFileId;
	private long ClientTimestamp;
	private long ScriptVersion;
	private String AppInfo;
	private String AppVersion;
	private String DeviceCode;
	private String DeviceId;
	private String DeviceName;
	private String ScriptId;
	private String TemplateVersion;

	@JSONField(name = "AppId")
	public int getAppId ( ) {
		return AppId;
	}

	@JSONField(name = "IsRedFinger")
	public int getIsRedFinger ( ) {
		return IsRedFinger;
	}

	@JSONField(name = "IsScriptHotUpgrade")
	public int getIsScriptHotUpgrade ( ) {
		return IsScriptHotUpgrade;
	}

	@JSONField(name = "TemplateFileId")
	public int getTemplateFileId ( ) {
		return TemplateFileId;
	}

	@JSONField(name = "ClientTimestamp")
	public long getClientTimestamp ( ) {
		return ClientTimestamp;
	}

	@JSONField(name = "ScriptVersion")
	public long getScriptVersion ( ) {
		return ScriptVersion;
	}

	@JSONField(name = "AppInfo")
	public String getAppInfo ( ) {
		return AppInfo;
	}

	@JSONField(name = "AppVersion")
	public String getAppVersion ( ) {
		return AppVersion;
	}


	@JSONField(name = "DeviceCode")
	public String getDeviceCode ( ) {
		return DeviceCode;
	}

	@JSONField(name = "DeviceId")
	public String getDeviceId ( ) {
		return DeviceId;
	}

	@JSONField(name = "DeviceName")
	public String getDeviceName ( ) {
		return DeviceName;
	}


	@JSONField(name = "ScriptId")
	public String getScriptId ( ) {
		return ScriptId;
	}

	@JSONField(name = "TemplateVersion")
	public String getTemplateVersion ( ) {
		return TemplateVersion;
	}

	public void setClientTimestamp ( long clientTimestamp ) {
		ClientTimestamp = clientTimestamp;
	}

	public void setAppId ( int appId ) {
		AppId = appId;
	}

	public void setIsScriptHotUpgrade ( int isScriptHotUpgrade ) {
		IsScriptHotUpgrade = isScriptHotUpgrade;
	}

	public void setScriptVersion ( long scriptVersion ) {
		ScriptVersion = scriptVersion;
	}

	public void setAppInfo ( String appInfo ) {
		AppInfo = appInfo;
	}

	public void setAppVersion ( String appVersion ) {
		AppVersion = appVersion;
	}

	public void setDeviceCode ( String deviceCode ) {
		DeviceCode = deviceCode;
	}

	public void setDeviceId ( String deviceId ) {
		DeviceId = deviceId;
	}

	public void setDeviceName ( String deviceName ) {
		DeviceName = deviceName;
	}

	public void setIsRedFinger ( int isRedFinger ) {
		IsRedFinger = isRedFinger;
	}

	public void setScriptId ( String scriptId ) {
		ScriptId = scriptId;
	}

	public void setScriptVersion ( int scriptVersion ) {
		ScriptVersion = scriptVersion;
	}

	public void setTemplateFileId ( int templateFileId ) {
		TemplateFileId = templateFileId;
	}

	public void setTemplateVersion ( String templateVersion ) {
		TemplateVersion = templateVersion;
	}
}
