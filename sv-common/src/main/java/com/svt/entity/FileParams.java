package com.svt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class FileParams {
    private String fileName;
    private String fileType;

    @JSONField(name = "fileName")
    public String getFileName() {
        return fileName;
    }

    @JSONField(name = "fileType")
    public String getFileType() {
        return fileType;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
