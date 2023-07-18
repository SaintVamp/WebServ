package com.svt.service.impl;


import com.svt.entity.MegapolisInfo;
import com.svt.mapper.MegapolisInfoMapper;
import com.svt.service.MegapolisServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MegapolisServImpl implements MegapolisServ {
	@Autowired
	private MegapolisInfoMapper megapolisInfoMapper;

	@Override
	public MegapolisInfo getMegapolis ( MegapolisInfo megapolisInfo ) throws Exception {
		return megapolisInfoMapper.select( megapolisInfo ).get( 0 );
	}

	@Override
	public int setMegapolis ( MegapolisInfo megapolisInfo ) throws Exception {
		return megapolisInfoMapper.insert( megapolisInfo );
	}

	@Override
	public int count ( ) throws Exception {
		return megapolisInfoMapper.count();
	}

	@Override
	public String getUnsentDay ( ) throws Exception {
		List<MegapolisInfo> list = megapolisInfoMapper.select( new MegapolisInfo( "", null, null, null, null, null, null, "0", null, null, null, null, null, null, null, null ) );
		StringBuilder r = new StringBuilder();
		for ( MegapolisInfo megapolisInfo : list ) {
			r.append( megapolisInfo.getId() ).append( "," );
		}
		return r.toString().replaceFirst( ".$", "" );
	}
}