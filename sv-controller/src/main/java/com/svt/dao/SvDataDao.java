package com.svt.dao;

import com.svt.entity.SvData;

import java.util.List;

public interface SvDataDao {
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

	int authCodeExist ( SvData svData ) throws Exception;

	int addSV ( SvData svData ) throws Exception;

	int modSV ( SvData svData ) throws Exception;
}
