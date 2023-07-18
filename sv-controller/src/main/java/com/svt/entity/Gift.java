package com.svt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;


@ToString
public class Gift {
    private String id;
    private String time;
    @JSONField(name = "id")
    public String getId ( ) {
        return id;
    }
    @JSONField(name = "time")
    public String getTime ( ) {
        return time;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public void setTime ( String time ) {
        this.time = time;
    }
}
