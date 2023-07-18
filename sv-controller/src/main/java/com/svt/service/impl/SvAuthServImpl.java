package com.svt.service.impl;

import com.svt.dao.SvAuthDao;
import com.svt.entity.SvAuth;
import com.svt.service.SvAuthServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SvAuthServImpl implements SvAuthServ {

	private SvAuthDao svAuthDao;

	@Autowired
	public SvAuthServImpl ( SvAuthDao svAuthDao ) {
		this.svAuthDao = svAuthDao;
	}

	public String login ( SvAuth svAuth ) {
		try {
			return svAuthDao.login( svAuth );
		} catch ( Exception e ) {
			return "";
		}
	}


}
