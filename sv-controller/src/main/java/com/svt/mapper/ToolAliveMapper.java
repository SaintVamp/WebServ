package com.svt.mapper;

import com.svt.entity.ToolAlive;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ToolAliveMapper {
    int count() throws Exception;

    int countParams( ToolAlive toolAlive) throws Exception;

    List<ToolAlive> list() throws Exception;

    List<ToolAlive> select( ToolAlive toolAlive) throws Exception;

    int insert( ToolAlive toolAlive) throws Exception;

    int update( ToolAlive toolAlive) throws Exception;


}
