package com.svt.service;

import com.svt.entity.tool.UpdateInfo;

public interface UpdateInfoServ {
    boolean isNeedUpdate(String toolName, long version) throws Exception;

    UpdateInfo getUpdateInfo(UpdateInfo updateInfo) throws Exception;

    int setUpdateInfo(UpdateInfo updateInfo) throws Exception;
}
