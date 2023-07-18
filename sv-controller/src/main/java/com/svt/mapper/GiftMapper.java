package com.svt.mapper;

import com.svt.entity.Gift;
import org.springframework.stereotype.Component;

@Component
public interface GiftMapper {

	int count ( ) throws Exception;

	int insert ( Gift gift ) throws Exception;

	int deleteAll ( ) throws Exception;

	int delete ( Gift gift ) throws Exception;
}
