package com.svt.service.impl;

import com.svt.entity.tool.ToolUpdate;
import com.svt.mapper.MybatisInit;
import com.svt.mapper.ToolUpdateMapper;
import com.svt.service.ToolUpdateServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolUpdateServImpl extends MybatisInit implements ToolUpdateServ {
	@Autowired
	private ToolUpdateMapper toolUpdateMapper;

	@Override
	public boolean isNeedUpdate ( String toolName, long version ) throws Exception {
		return toolUpdateMapper.getVersion( toolName ) > version;
	}

	@Override
	public ToolUpdate getUpdateInfo ( String toolName ) throws Exception {
		return toolUpdateMapper.getUpdateInfo( toolName );
	}

	@Override
	public int updateInfo ( ToolUpdate toolUpdate ) throws Exception {
		return toolUpdateMapper.update( toolUpdate );
	}
}
