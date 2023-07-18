package com.svt.service.impl;

import com.svt.entity.Quest;
import com.svt.mapper.MybatisInit;
import com.svt.mapper.QuestMapper;
import com.svt.service.QuestServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestServImpl extends MybatisInit implements QuestServ {
	@Autowired
	private QuestMapper questMapper;

	@Override
	public String getQuest ( Quest quest ) throws Exception {
		Quest quest1 = questMapper.select( quest );
		return quest1.getFlag() + "," + quest1.getPositive();
	}

	@Override
	public int setQuest ( Quest quest ) throws Exception {
		return questMapper.insert( quest );
	}
}
