package com.svt.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class SvData {
    private String qqNum;
    private String authCode;
    private String device;
    private String startDt;
    private String endDt;
    private String localIp;
    private Integer price;
    private String updateDt;
    private String version;
    private String game;

    public String getAuthCode() {
        return authCode;
    }

    public String getDevice() {
        return device;
    }

    public String getQqNum() {
        return qqNum;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public String getVersion() {
        return version;
    }

    public String getStartDt() {
        return startDt;
    }

    public Integer getPrice() {
        return price;
    }

    public String getEndDt() {
        return endDt;
    }

    public String getGame() {
        return game;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }
}

