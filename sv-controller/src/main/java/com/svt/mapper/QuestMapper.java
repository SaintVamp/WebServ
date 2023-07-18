package com.svt.mapper;

import com.svt.entity.Quest;
import org.springframework.stereotype.Component;

@Component
public interface QuestMapper {

	Quest select ( Quest quest) throws Exception;

	int insert ( Quest quest ) throws Exception;

}
