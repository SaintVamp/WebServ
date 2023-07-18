package com.svt.entity.tool;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ToolUpdate extends ResponseTime {
	private String PackageName;
	private String AppName;
	private String UpdateContent;
	private String UpdateUrl;
	private String StudioProjectKey;
	private String DeviceName;
	private int UpdateType;
	private int InstanceDataUploadInterval;
	private int UpgradeMode;
	private long AppVersion;
	private long PackageSize;
	private long AppUpdateTime;



	public ToolUpdate ( long timestamp ) {
		super( timestamp );
	}

	@JSONField(name = "AppVersion")
	public long getAppVersion ( ) {
		return AppVersion;
	}

	@JSONField(name = "InstanceDataUploadInterval")
	public int getInstanceDataUploadInterval ( ) {
		return InstanceDataUploadInterval;
	}

	@JSONField(name = "UpdateType")
	public int getUpdateType ( ) {
		return UpdateType;
	}

	@JSONField(name = "UpgradeMode")
	public int getUpgradeMode ( ) {
		return UpgradeMode;
	}

	@JSONField(name = "AppUpdateTime")
	public long getAppUpdateTime ( ) {
		return AppUpdateTime;
	}

	@JSONField(name = "PackageSize")
	public long getPackageSize ( ) {
		return PackageSize;
	}

	@JSONField(name = "AppName")
	public String getAppName ( ) {
		return AppName;
	}

	@JSONField(name = "PackageName")
	public String getPackageName ( ) {
		return PackageName;
	}

	@JSONField(name = "StudioProjectKey")
	public String getStudioProjectKey ( ) {
		return StudioProjectKey;
	}

	@JSONField(name = "UpdateContent")
	public String getUpdateContent ( ) {
		return UpdateContent;
	}

	@JSONField(name = "UpdateUrl")
	public String getUpdateUrl ( ) {
		return UpdateUrl;
	}

	@JSONField(name = "DeviceName")
	public String getDeviceName ( ) {
		return DeviceName;
	}

	public void setAppName ( String appName ) {
		AppName = appName;
	}

	public void setAppUpdateTime ( long appUpdateTime ) {
		AppUpdateTime = appUpdateTime;
	}

	public void setAppVersion ( long appVersion ) {
		AppVersion = appVersion;
	}

	public void setInstanceDataUploadInterval ( int instanceDataUploadInterval ) {
		InstanceDataUploadInterval = instanceDataUploadInterval;
	}

	public void setPackageName ( String packageName ) {
		PackageName = packageName;
	}

	public void setPackageSize ( long packageSize ) {
		PackageSize = packageSize;
	}

	public void setStudioProjectKey ( String studioProjectKey ) {
		StudioProjectKey = studioProjectKey;
	}

	public void setUpdateContent ( String updateContent ) {
		UpdateContent = updateContent;
	}

	public void setUpdateType ( int updateType ) {
		UpdateType = updateType;
	}

	public void setUpdateUrl ( String updateUrl ) {
		UpdateUrl = updateUrl;
	}

	public void setUpgradeMode ( int upgradeMode ) {
		UpgradeMode = upgradeMode;
	}

	public void setDeviceName ( String deviceName ) {
		DeviceName = deviceName;
	}
}
