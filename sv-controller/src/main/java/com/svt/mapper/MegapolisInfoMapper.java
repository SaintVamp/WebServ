package com.svt.mapper;

import com.svt.entity.MegapolisInfo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MegapolisInfoMapper {
    List<MegapolisInfo> list() throws Exception;

    int count() throws Exception;

    List<MegapolisInfo> select( MegapolisInfo megapolisInfo) throws Exception;

    int update( MegapolisInfo megapolisInfo) throws Exception;

    int insert( MegapolisInfo megapolisInfo) throws Exception;


}
