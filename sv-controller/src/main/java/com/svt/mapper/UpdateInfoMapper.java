package com.svt.mapper;


import com.svt.entity.tool.UpdateInfo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UpdateInfoMapper {


    String getVersion(String toolName) throws Exception;

    List<UpdateInfo> select( UpdateInfo updateInfo) throws Exception;

    int insert( UpdateInfo updateInfo) throws Exception;

    int update( UpdateInfo updateInfo) throws Exception;

    int delete( UpdateInfo updateInfo) throws Exception;

    int count() throws Exception;

    List<UpdateInfo> list() throws Exception;

}
