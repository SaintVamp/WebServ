package com.svt.service.impl;

import com.svt.entity.Gift;
import com.svt.mapper.GiftMapper;
import com.svt.service.GiftServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftServImpl implements GiftServ {
	@Autowired
	private GiftMapper giftMapper;

	@Override
	public String getRunning ( ) throws Exception {
		return String.valueOf( giftMapper.count() );
	}

	@Override
	public int setRunning ( Gift gift ) throws Exception {
		return giftMapper.insert( gift );
	}

	@Override
	public int delRunningAll ( ) throws Exception {
		return giftMapper.deleteAll();
	}

	@Override
	public int delRunning ( Gift gift ) throws Exception {
		return giftMapper.delete( gift );
	}
}
