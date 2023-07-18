package com.svt.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Anjian {
    private String package_name;
    private String attr;
    private String val;

    public String getVal() {
        return val;
    }

    public String getPackage_name() {
        return package_name;
    }

    public String getAttr() {
        return attr;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }
}
