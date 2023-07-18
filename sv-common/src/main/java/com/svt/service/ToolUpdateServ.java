package com.svt.service;

import com.svt.entity.tool.ToolUpdate;

public interface ToolUpdateServ {
	boolean isNeedUpdate ( String toolName, long version ) throws Exception;

	ToolUpdate getUpdateInfo ( String toolName ) throws Exception;

	int updateInfo ( ToolUpdate toolUpdate ) throws Exception;
}
