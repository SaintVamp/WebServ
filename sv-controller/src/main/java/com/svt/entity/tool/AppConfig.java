package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

public class AppConfig extends ResponseTime {
	private int RedFingerSwitch;
	private String AppDomainName;
	private String App2DomainName;
	private String App3DomainName;
	private List<PhoneConfig> PhoneConfigs;

	public AppConfig ( long timestamp) {
		super(timestamp);
		this.RedFingerSwitch = 0;
		this.AppDomainName = "http://saintvamp.f3322.net:8848/Serv/anjian/";
		this.App2DomainName = "http://saintvamp.f3322.net:8848/Serv/anjian";
		this.App3DomainName = "http://saintvamp.f3322.net:8848/Serv/anjian";
		List<PhoneConfig> list = new ArrayList<>();
		list.add( new PhoneConfig() );
		this.PhoneConfigs = list;
	}

	@JSONField(name = "RedFingerSwitch")
	public int getRedFingerSwitch ( ) {
		return RedFingerSwitch;
	}

	@JSONField(name = "App2DomainName")
	public String getApp2DomainName ( ) {
		return App2DomainName;
	}

	@JSONField(name = "App3DomainName")
	public String getApp3DomainName ( ) {
		return App3DomainName;
	}

	@JSONField(name = "AppDomainName")
	public String getAppDomainName ( ) {
		return AppDomainName;
	}

	@JSONField(name = "PhoneConfig")
	public List<PhoneConfig> getPhoneConfigs ( ) {
		return PhoneConfigs;
	}

	public void setApp2DomainName ( String app2DomainName ) {
		App2DomainName = app2DomainName;
	}

	public void setApp3DomainName ( String app3DomainName ) {
		App3DomainName = app3DomainName;
	}

	public void setAppDomainName ( String appDomainName ) {
		AppDomainName = appDomainName;
	}

	public void setPhoneConfigs ( List<PhoneConfig> phoneConfigs ) {
		PhoneConfigs = phoneConfigs;
	}

	public void setRedFingerSwitch ( int redFingerSwitch ) {
		RedFingerSwitch = redFingerSwitch;
	}
}
