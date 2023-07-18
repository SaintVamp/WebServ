package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class UpdateInfo {
    private String ToolName;
    private String DownLoadPath;
    private String UpdateNotice;
    private String UpdateType;
    private String UpdateTime;
    private String FileSize;
    private String Version;

    public UpdateInfo(String ToolName, String DownLoadPath, String UpdateNotice, String UpdateType, String UpdateTime, String FileSize, String Version) {
        this.ToolName = ToolName;
        this.DownLoadPath = DownLoadPath;
        this.UpdateNotice = UpdateNotice;
        this.UpdateType = UpdateType;
        this.UpdateTime = UpdateTime;
        this.FileSize = FileSize;
        this.Version = Version;
    }

    @JSONField(name = "DownLoadPath")
    public String getDownLoadPath() {
        return DownLoadPath;
    }

    @JSONField(name = "FileSize")
    public String getFileSize() {
        return FileSize;
    }

    @JSONField(name = "UpdateTime")
    public String getUpdateTime() {
        return UpdateTime;
    }

    @JSONField(name = "Version")
    public String getVersion() {
        return Version;
    }

    @JSONField(name = "ToolName")
    public String getToolName() {
        return ToolName;
    }

    @JSONField(name = "UpdateNotice")
    public String getUpdateNotice() {
        return UpdateNotice;
    }

    @JSONField(name = "UpdateType")
    public String getUpdateType() {
        return UpdateType;
    }

    public void setUpdateType(String updateType) {
        UpdateType = updateType;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public void setDownLoadPath(String downLoadPath) {
        DownLoadPath = downLoadPath;
    }

    public void setFileSize(String fileSize) {
        FileSize = fileSize;
    }

    public void setToolName(String toolName) {
        ToolName = toolName;
    }

    public void setUpdateNotice(String updateNotice) {
        UpdateNotice = updateNotice;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }
}
