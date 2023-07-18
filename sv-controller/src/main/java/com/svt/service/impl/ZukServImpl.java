package com.svt.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.svt.entity.Contract;
import com.svt.entity.ToolAlive;
import com.svt.mapper.ContractMapper;
import com.svt.mapper.MybatisInit;
import com.svt.mapper.ToolAliveMapper;
import com.svt.service.ZukServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ZukServImpl extends MybatisInit implements ZukServ {
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private ToolAliveMapper toolAliveMapper;

	@Override
	public String getAreaNum ( Contract contract ) throws Exception {
		List<Contract> list = contractMapper.select( contract );
		StringBuilder r = new StringBuilder();
		for ( Contract contract1 : list ) {
			r.append( contract1.getId() ).append( "," );
		}
		return r.toString().replaceFirst( ".$", "" );
	}

	@Override
	public int setContractTime ( Contract contract ) throws Exception {
		return contractMapper.update( contract );
	}

	public String getContractTime ( Contract contract ) throws Exception {
		contract.setTimestamp( "" );
		List<Contract> contractList = contractMapper.select( contract );
		return contractList.get( 0 ).getTimestamp();
	}


	@Override
	public Contract getContractOperation ( Contract contract ) throws Exception {
		contract.setOperation( "" );
		List<Contract> contractList = contractMapper.select( contract );
		return contractList.get( 0 );
	}

	@Override
	public int setContractOperation ( Contract contract ) throws Exception {
		return contractMapper.update( contract );
	}

	@Override
	public String getContractTimeAll ( ) throws Exception {
		Contract contract = new Contract( "", null, "", null, null, null, null );
		List<Contract> contractList = contractMapper.select( contract );
		return JSONObject.toJSONString( contractList );
	}

	@Override
	public int setToolHeart ( ToolAlive toolAlive ) throws Exception {
		int i;
		ToolAlive toolAlive1 = new ToolAlive( toolAlive.getToolName(), toolAlive.getCode(), null, null );
		if ( toolAliveMapper.countParams( toolAlive1 ) > 0 ) {
			i = toolAliveMapper.update( toolAlive );
		} else {
			i = toolAliveMapper.insert( toolAlive );
		}
		return i;
	}

	@Override
	public String getToolHeart ( ToolAlive toolAlive ) throws Exception {
		List<ToolAlive> toolAliveList = toolAliveMapper.select( toolAlive );
		return toolAliveList.get( 0 ).getTimestamp();
	}

}