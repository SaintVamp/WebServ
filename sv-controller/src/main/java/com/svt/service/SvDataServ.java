package com.svt.service;

import com.svt.entity.SvData;

import java.util.List;

public interface SvDataServ {
	int reg ( SvData svData ) throws Exception;

	int update ( SvData svData ) throws Exception;

	int updateD ( SvData svData ) throws Exception;

	List<SvData> searchQQ ( String qq ) throws Exception;

	int searchVer ( String ver ) throws Exception;

	SvData searchKey ( String k ) throws Exception;

	SvData searchKeyToC ( String k ) throws Exception;

	List<SvData> countAll ( ) throws Exception;

	List<SvData> searchAll ( ) throws Exception;

	int delete ( String k ) throws Exception;

	void syncDb ( ) throws Exception;
}
