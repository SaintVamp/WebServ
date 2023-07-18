package com.svt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class Contract {
    private String name;
    private String id;
    private String time;
    private String timestamp;
    private String flag;
    private String operation;
    private String updateDt;

    public Contract() {
    }

    public Contract(String name, String id, String time, String timestamp, String flag, String operation, String updateDt) {
        this.name = name;
        this.id = id;
        this.time = time;
        this.timestamp = timestamp;
        this.flag = flag;
        this.operation = operation;
        this.updateDt = updateDt;
    }

    @JSONField(name = "updateDt")
    public String getUpdateDt() {
        return updateDt;
    }

    @JSONField(name = "operation")
    public String getOperation() {
        return operation;
    }

    @JSONField(name = "time")
    public String getTime() {
        return time;
    }

    @JSONField(name = "id")
    public String getId() {
        return id;
    }

    @JSONField(name = "name")
    public String getName() {
        return name;
    }

    @JSONField(name = "flag")
    public String getFlag() {
        return flag;
    }

    @JSONField(name = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
