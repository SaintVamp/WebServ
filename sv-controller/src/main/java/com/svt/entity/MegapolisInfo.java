package com.svt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;


@ToString
public class MegapolisInfo {
	private String id;
	private String group;
	private String version;
	private String toolVer;
	private String manual;
	private String gameVer;
	private String assistFlag;
	private String dailySend;
	private String animation;
	private String timestamp;
	private String startStatus;
	private String gameScale;
	private String backupSim;
	private String createStatus;
	private String backupGame;
	private String assistUpgrade;

	public MegapolisInfo ( String id, String group, String version, String toolVer, String manual, String gameVer, String assistFlag, String dailySend, String animation, String timestamp, String startStatus, String gameScale, String backupSim, String createStatus, String backupGame, String assistUpgrade ) {
		this.id = id;
		this.group = group;
		this.version = version;
		this.toolVer = toolVer;
		this.manual = manual;
		this.gameVer = gameVer;
		this.assistFlag = assistFlag;
		this.dailySend = dailySend;
		this.animation = animation;
		this.timestamp = timestamp;
		this.startStatus = startStatus;
		this.gameScale = gameScale;
		this.backupSim = backupSim;
		this.createStatus = createStatus;
		this.backupGame = backupGame;
		this.assistUpgrade = assistUpgrade;
	}

	@JSONField(name = "id")
	public String getId ( ) {
		return id;
	}

	@JSONField(name = "version")
	public String getVersion ( ) {
		return version;
	}

	@JSONField(name = "animation")
	public String getAnimation ( ) {
		return animation;
	}

	@JSONField(name = "backupGame")
	public String getBackupGame ( ) {
		return backupGame;
	}

	@JSONField(name = "backupSim")
	public String getBackupSim ( ) {
		return backupSim;
	}

	@JSONField(name = "group")
	public String getGroup ( ) {
		return group;
	}

	@JSONField(name = "manual")
	public String getManual ( ) {
		return manual;
	}

	@JSONField(name = "assistFlag")
	public String getAssistFlag ( ) {
		return assistFlag;
	}

	@JSONField(name = "createStatus")
	public String getCreateStatus ( ) {
		return createStatus;
	}

	@JSONField(name = "dailySend")
	public String getDailySend ( ) {
		return dailySend;
	}

	@JSONField(name = "gameScale")
	public String getGameScale ( ) {
		return gameScale;
	}

	@JSONField(name = "startStatus")
	public String getStartStatus ( ) {
		return startStatus;
	}

	@JSONField(name = "assistUpgrade")
	public String getAssistUpgrade ( ) {
		return assistUpgrade;
	}

	@JSONField(name = "gameVer")
	public String getGameVer ( ) {
		return gameVer;
	}

	@JSONField(name = "timestamp")
	public String getTimestamp ( ) {
		return timestamp;
	}

	@JSONField(name = "toolVer")
	public String getToolVer ( ) {
		return toolVer;
	}

	public void setAnimation ( String animation ) {
		this.animation = animation;
	}

	public void setAssistFlag ( String assistFlag ) {
		this.assistFlag = assistFlag;
	}

	public void setBackupGame ( String backupGame ) {
		this.backupGame = backupGame;
	}

	public void setAssistUpgrade ( String assistUpgrade ) {
		this.assistUpgrade = assistUpgrade;
	}

	public void setBackupSim ( String backupSim ) {
		this.backupSim = backupSim;
	}

	public void setCreateStatus ( String createStatus ) {
		this.createStatus = createStatus;
	}

	public void setDailySend ( String dailySend ) {
		this.dailySend = dailySend;
	}

	public void setGameScale ( String gameScale ) {
		this.gameScale = gameScale;
	}

	public void setGameVer ( String gameVer ) {
		this.gameVer = gameVer;
	}

	public void setGroup ( String group ) {
		this.group = group;
	}

	public void setId ( String id ) {
		this.id = id;
	}

	public void setManual ( String manual ) {
		this.manual = manual;
	}

	public void setStartStatus ( String startStatus ) {
		this.startStatus = startStatus;
	}

	public void setTimestamp ( String timestamp ) {
		this.timestamp = timestamp;
	}

	public void setToolVer ( String toolVer ) {
		this.toolVer = toolVer;
	}

	public void setVersion ( String version ) {
		this.version = version;
	}
}
