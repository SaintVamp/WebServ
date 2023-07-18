package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;

public class PhoneConfig {
	private int Active;
	private int JudgeMode;
	private int CloudPhoneType;
	private String DisableMsg;
	private String Package;
	private String ImageUrl;
	private String LinkUrl;

	public PhoneConfig ( ) {
		super();
		this.Active = 0;
		this.CloudPhoneType = 6;
		this.JudgeMode = 1;
		this.Package = "a.a.a";
		this.DisableMsg = "";
		this.ImageUrl = "";
		this.LinkUrl = "";
	}

	@JSONField(name = "Active")
	public int getActive ( ) {
		return Active;
	}

	@JSONField(name = "CloudPhoneType")
	public int getCloudPhoneType ( ) {
		return CloudPhoneType;
	}

	@JSONField(name = "JudgeMode")
	public int getJudgeMode ( ) {
		return JudgeMode;
	}

	@JSONField(name = "DisableMsg")
	public String getDisableMsg ( ) {
		return DisableMsg;
	}

	@JSONField(name = "ImageUrl")
	public String getImageUrl ( ) {
		return ImageUrl;
	}

	@JSONField(name = "LinkUrl")
	public String getLinkUrl ( ) {
		return LinkUrl;
	}

	@JSONField(name = "Package")
	public String getPackage ( ) {
		return Package;
	}

	public void setJudgeMode ( int judgeMode ) {
		JudgeMode = judgeMode;
	}

	public void setImageUrl ( String imageUrl ) {
		ImageUrl = imageUrl;
	}

	public void setPackage ( String aPackage ) {
		Package = aPackage;
	}

	public void setActive ( int active ) {
		Active = active;
	}

	public void setCloudPhoneType ( int cloudPhoneType ) {
		CloudPhoneType = cloudPhoneType;
	}

	public void setDisableMsg ( String disableMsg ) {
		DisableMsg = disableMsg;
	}

	public void setLinkUrl ( String linkUrl ) {
		LinkUrl = linkUrl;
	}
}
