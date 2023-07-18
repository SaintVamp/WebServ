package com.svt.service.impl;

import com.svt.entity.tool.ToolUpdate;
import com.svt.mapper.MybatisInit;
import com.svt.mapper.ToolUpdateMapper;
import com.svt.service.ToolUpdateServ;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy()
public class ToolUpdateServImpl extends MybatisInit implements ToolUpdateServ {
	private ToolUpdateMapper toolUpdateMapper;

	@Override
	public boolean isNeedUpdate ( String toolName, long version ) throws Exception {
		try {
			toolUpdateMapper = (ToolUpdateMapper) init( "com.svt.mapper.ToolUpdateMapper" );
			return toolUpdateMapper.getVersion( toolName ) > version;
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public ToolUpdate getUpdateInfo ( String toolName ) throws Exception {
		try {
			toolUpdateMapper = (ToolUpdateMapper) init( "com.svt.mapper.ToolUpdateMapper" );
			return toolUpdateMapper.getUpdateInfo( toolName );
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public int updateInfo ( ToolUpdate toolUpdate ) throws Exception {
		try {
			toolUpdateMapper = (ToolUpdateMapper) init( "com.svt.mapper.ToolUpdateMapper" );
			return toolUpdateMapper.update( toolUpdate );
		} finally {
			mybatisTools.commitCurrentSqlSession();
			mybatisTools.closeCurrentSqlSession();
		}
	}
}
