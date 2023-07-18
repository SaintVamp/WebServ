package com.svt.service.impl;

import com.svt.common.MysqlUtil;
import com.svt.dao.SvDataDao;
import com.svt.entity.SvData;
import com.svt.service.SvDataServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy()
public class SvDataServImpl implements SvDataServ {
	private final SvDataDao svDataDao;

	@Autowired
	public SvDataServImpl ( SvDataDao svDataDao ) {
		this.svDataDao = svDataDao;
	}

	@Override
	public int reg ( SvData svData ) throws Exception {
		return svDataDao.reg( svData );
	}

	@Override
	public int update ( SvData svData ) throws Exception {
		return svDataDao.update( svData );
	}

	@Override
	public int updateD ( SvData svData ) throws Exception {
		return svDataDao.updateD( svData );
	}

	@Override
	public List<SvData> searchQQ ( String qq ) throws Exception {
		return svDataDao.searchQQ( qq );
	}

	@Override
	public int searchVer ( String ver ) throws Exception {
		return svDataDao.searchVer( ver );
	}

	@Override
	public SvData searchKey ( String k ) throws Exception {
		return svDataDao.searchKey( k );
	}

	@Override
	public SvData searchKeyToC ( String k ) throws Exception {
		return svDataDao.searchKeyToC( k );
	}

	@Override
	public List<SvData> countAll ( ) throws Exception {
		return svDataDao.countAll();
	}

	@Override
	public List<SvData> searchAll ( ) throws Exception {
		return svDataDao.searchAll();
	}

	@Override
	public int delete ( String k ) throws Exception {
		return svDataDao.delete( k );
	}


	@Override
	public void syncDb ( ) throws Exception {
		List<SvData> svDataList = new MysqlUtil().mongoDb();
		for ( SvData svData : svDataList ) {
			int flag = svDataDao.authCodeExist( svData );
			if ( flag == 2 ) {
				svDataDao.addSV( svData );
			} else if ( flag == 1 ) {
				svDataDao.modSV( svData );
			}
		}
	}


}
