package com.svt.service.impl;


import com.svt.entity.MegapolisInfo;
import com.svt.mapper.MegapolisInfoMapper;
import com.svt.mapper.MybatisInit;
import com.svt.service.MegapolisServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MegapolisServImpl extends MybatisInit implements MegapolisServ {
	@Autowired
	private MegapolisInfoMapper megapolisInfoMapper;

	@Override
	public MegapolisInfo getMegapolis ( MegapolisInfo megapolisInfo ) throws Exception {
		try {
			megapolisInfoMapper = (MegapolisInfoMapper) init( "com.svt.mapper.MegapolisInfoMapper" );
			return megapolisInfoMapper.select( megapolisInfo ).get( 0 );
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public int setMegapolis ( MegapolisInfo megapolisInfo ) throws Exception {
		try {
			megapolisInfoMapper = (MegapolisInfoMapper) init( "com.svt.mapper.MegapolisInfoMapper" );
			return megapolisInfoMapper.insert( megapolisInfo );
		} finally {
			mybatisTools.commitCurrentSqlSession();
			mybatisTools.closeCurrentSqlSession();
		}
	}


	@Override
	public int count ( ) throws Exception {
		try {
			megapolisInfoMapper = (MegapolisInfoMapper) init( "com.svt.mapper.MegapolisInfoMapper" );
			return megapolisInfoMapper.count();
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public String getUnsentDay ( ) throws Exception {
		try {
			megapolisInfoMapper = (MegapolisInfoMapper) init( "com.svt.mapper.MegapolisInfoMapper" );
			List<MegapolisInfo> list = megapolisInfoMapper.select( new MegapolisInfo( "", null, null, null, null, null, null, "0", null, null, null, null, null, null, null, null ) );
			StringBuilder r = new StringBuilder();
			for ( MegapolisInfo megapolisInfo : list ) {
				r.append( megapolisInfo.getId() ).append( "," );
			}
			return r.toString().replaceFirst( ".$", "" );
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}


}