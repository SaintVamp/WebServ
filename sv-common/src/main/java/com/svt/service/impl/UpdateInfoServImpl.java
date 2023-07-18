package com.svt.service.impl;

import com.svt.entity.tool.UpdateInfo;
import com.svt.mapper.MybatisInit;
import com.svt.mapper.UpdateInfoMapper;
import com.svt.service.UpdateInfoServ;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy()
public class UpdateInfoServImpl extends MybatisInit implements UpdateInfoServ {
	private UpdateInfoMapper updateInfoMapper;

	@Override
	public boolean isNeedUpdate ( String toolName, long version ) throws Exception {
		try {
			updateInfoMapper = (UpdateInfoMapper) init( "com.svt.mapper.UpdateInfoMapper" );
			return Long.parseLong( updateInfoMapper.getVersion( toolName ) ) > version;
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public UpdateInfo getUpdateInfo ( UpdateInfo updateInfo ) throws Exception {
		try {
			updateInfoMapper = (UpdateInfoMapper) init( "com.svt.mapper.UpdateInfoMapper" );
			return updateInfoMapper.select( updateInfo ).get(0);
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public int setUpdateInfo ( UpdateInfo updateInfo ) throws Exception {
		try {
			updateInfoMapper = (UpdateInfoMapper) init( "com.svt.mapper.UpdateInfoMapper" );
			return updateInfoMapper.update( updateInfo );
		} finally {
			mybatisTools.commitCurrentSqlSession();
			mybatisTools.closeCurrentSqlSession();
		}
	}
}
