package com.svt.mapper;

import com.svt.entity.tool.ToolUpdate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ToolUpdateMapper {

	ToolUpdate getUpdateInfo ( String toolName ) throws Exception;

	Long getVersion ( String toolName ) throws Exception;

	int insert ( ToolUpdate toolUpdate ) throws Exception;

	int update ( ToolUpdate toolUpdate ) throws Exception;

	int delete ( ToolUpdate toolUpdate ) throws Exception;

	int count ( ) throws Exception;

	List<ToolUpdate> list ( ) throws Exception;

}
