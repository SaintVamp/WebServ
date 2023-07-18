package com.svt.service.impl;

import com.svt.entity.Gift;
import com.svt.mapper.GiftMapper;
import com.svt.mapper.MybatisInit;
import com.svt.service.GiftServ;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy()
public class GiftServImpl extends MybatisInit implements GiftServ {
	private GiftMapper giftMapper;

	@Override
	public String getRunning ( ) throws Exception {
		try {
			giftMapper = (GiftMapper) init( "com.svt.mapper.GiftMapper" );
			return String.valueOf( giftMapper.count() );
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public int setRunning ( Gift gift ) throws Exception {
		try {
			giftMapper = (GiftMapper) init( "com.svt.mapper.GiftMapper" );
			return giftMapper.insert( gift );
		} finally {
			mybatisTools.commitCurrentSqlSession();
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public int delRunningAll ( ) throws Exception {
		try {
			giftMapper = (GiftMapper) init( "com.svt.mapper.GiftMapper" );
			return giftMapper.deleteAll();
		} finally {
			mybatisTools.commitCurrentSqlSession();
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public int delRunning ( Gift gift ) throws Exception {
		try {
			giftMapper = (GiftMapper) init( "com.svt.mapper.GiftMapper" );
			return giftMapper.delete( gift );
		} finally {
			mybatisTools.commitCurrentSqlSession();
			mybatisTools.closeCurrentSqlSession();
		}
	}
}
