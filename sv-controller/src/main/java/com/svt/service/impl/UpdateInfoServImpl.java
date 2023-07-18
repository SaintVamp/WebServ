package com.svt.service.impl;

import com.svt.entity.tool.UpdateInfo;
import com.svt.mapper.UpdateInfoMapper;
import com.svt.service.UpdateInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateInfoServImpl implements UpdateInfoServ {
	@Autowired
	private UpdateInfoMapper updateInfoMapper;

	@Override
	public boolean isNeedUpdate ( String toolName, long version ) throws Exception {
		return Long.parseLong( updateInfoMapper.getVersion( toolName ) ) > version;
	}

	@Override
	public UpdateInfo getUpdateInfo ( UpdateInfo updateInfo ) throws Exception {
		return updateInfoMapper.select( updateInfo ).get( 0 );
	}

	@Override
	public int setUpdateInfo ( UpdateInfo updateInfo ) throws Exception {
		return updateInfoMapper.update( updateInfo );
	}
}
