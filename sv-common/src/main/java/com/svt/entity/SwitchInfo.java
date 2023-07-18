package com.svt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;


@ToString
public class SwitchInfo {
    private String switchId;
    private String switchStatus;
    private String remark;

    public SwitchInfo() {
    }

    public SwitchInfo(String switchId, String switchStatus, String remark) {
        this.switchId = switchId;
        this.switchStatus = switchStatus;
        this.remark = remark;
    }

    @JSONField(name = "switchId")
    public String getSwitchId() {
        return switchId;
    }

    @JSONField(name = "switchStatus")
    public String getSwitchStatus() {
        return switchStatus;
    }

    @JSONField(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setSwitchId(String switchId) {
        this.switchId = switchId;
    }

    public void setSwitchStatus(String switchStatus) {
        this.switchStatus = switchStatus;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
