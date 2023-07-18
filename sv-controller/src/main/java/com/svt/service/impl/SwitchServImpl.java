package com.svt.service.impl;


import com.svt.common.JsonUtil;
import com.svt.entity.SwitchInfo;
import com.svt.mapper.MybatisInit;
import com.svt.mapper.SwitchInfoMapper;
import com.svt.service.SwitchServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;


@Service
public class SwitchServImpl extends MybatisInit implements SwitchServ {
	@Autowired
	private SwitchInfoMapper switchInfoMapper;

	@Override
	public boolean getWakeUpTablet ( ) throws Exception {
		return switchInfoMapper.select( new SwitchInfo( "runTablet", "", null ) ).get( 0 ).getSwitchStatus().equals( "true" );
	}

	@Override
	public boolean getCheckZuk ( ) throws Exception {
		return switchInfoMapper.select( new SwitchInfo( "ZukRunning", "", null ) ).get( 0 ).getSwitchStatus().equals( "true" );
	}

	@Override
	public boolean checkGiftSending ( ) throws Exception {
		return switchInfoMapper.select( new SwitchInfo( "isSending", "", null ) ).get( 0 ).getSwitchStatus().equals( "yes" );
	}

	@Override
	public boolean getCheckRunning ( ) throws Exception {
		return switchInfoMapper.select( new SwitchInfo( "GiftRunning", "", null ) ).get( 0 ).getSwitchStatus().equals( "true" );
	}

	@Override
	public Boolean checkRemainSim ( String ids ) {
		try {
			String finalStr = "d41d8cd98f00b204e9800998ecf8427e";  // ""的MD5值
			String nowStr = DigestUtils.md5DigestAsHex( ids.getBytes() );
			SwitchInfo switchInfo = new SwitchInfo( "remainSim", "", "" );
			if ( finalStr.equals( nowStr ) ) {
				return false;
			} else if ( switchInfoMapper.select( switchInfo ).get( 0 ).getSwitchStatus().equals( nowStr ) ) {
				return true;
			} else {
				switchInfo.setRemark( "" );
				switchInfoMapper.insert( switchInfo );
				return false;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public String getSwitch ( SwitchInfo switchInfo ) throws Exception {
		List<SwitchInfo> switchInfos = switchInfoMapper.select( switchInfo );
		return switchInfos.get( 0 ).getSwitchStatus();
	}

	@Override
	public String getSwitchAll ( ) throws Exception {
		return new JsonUtil().List2String( switchInfoMapper.list() );
	}


	@Override
	public int setSwitch ( SwitchInfo switchInfo ) throws Exception {
		return switchInfoMapper.update( switchInfo );
	}


	@Override
	public int addSwitch ( SwitchInfo switchInfo ) throws Exception {
		return switchInfoMapper.insert( switchInfo );
	}
}