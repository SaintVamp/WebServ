package com.svt.mapper;

import com.svt.entity.SwitchInfo;

import java.util.List;

public interface SwitchInfoMapper {
	List<SwitchInfo> list ( ) throws Exception;

	List<SwitchInfo> select ( SwitchInfo switchInfo ) throws Exception;

	int update ( SwitchInfo switchInfo ) throws Exception;

	int insert ( SwitchInfo switchInfo ) throws Exception;


}
