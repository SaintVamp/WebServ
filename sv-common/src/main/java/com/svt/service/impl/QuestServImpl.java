package com.svt.service.impl;

import com.svt.entity.Quest;
import com.svt.mapper.MybatisInit;
import com.svt.mapper.QuestMapper;
import com.svt.service.QuestServ;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy()
public class QuestServImpl extends MybatisInit implements QuestServ {
	private QuestMapper questMapper;

	@Override
	public String getQuest ( Quest quest ) throws Exception {
		try {
			questMapper = (QuestMapper) init( "com.svt.mapper.QuestMapper" );
			Quest quest1 = questMapper.select( quest );
			return quest1.getFlag() + "," + quest1.getPositive();
		} finally {
			mybatisTools.closeCurrentSqlSession();
		}
	}

	@Override
	public int setQuest ( Quest quest ) throws Exception {
		try {
			questMapper = (QuestMapper) init( "com.svt.mapper.QuestMapper" );
			return questMapper.insert( quest );
		} finally {
			mybatisTools.commitCurrentSqlSession();
			mybatisTools.closeCurrentSqlSession();
		}
	}
}
