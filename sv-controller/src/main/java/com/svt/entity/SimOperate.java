package com.svt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class SimOperate {
    private String id;

    @JSONField(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
