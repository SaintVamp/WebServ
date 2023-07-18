package com.svt.service;

import com.svt.entity.Quest;

public interface QuestServ {
	String getQuest( Quest quest ) throws Exception;

	int setQuest (  Quest quest ) throws Exception;

}
