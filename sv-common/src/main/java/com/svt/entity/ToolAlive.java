package com.svt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;


@ToString
public class ToolAlive {
    private String toolName;
    private String code;
    private String status;
    private String timestamp;

    public ToolAlive() {
    }

    public ToolAlive(String toolName, String code, String status, String timestamp) {
        this.toolName = toolName;
        this.code = code;
        this.status = status;
        this.timestamp = timestamp;
    }

    @JSONField(name = "toolName")
    public String getToolName() {
        return toolName;
    }

    @JSONField(name = "code")
    public String getCode() {
        return code;
    }

    @JSONField(name = "status")
    public String getStatus() {
        return status;
    }

    @JSONField(name = "timestamp")
    public String  getTimestamp() {
        return timestamp;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTimestamp(String  timestamp) {
        this.timestamp = timestamp;
    }
}
