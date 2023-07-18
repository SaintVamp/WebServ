package com.svt.service;

import com.svt.entity.Contract;
import com.svt.entity.ToolAlive;

public interface ZukServ {
    String getAreaNum( Contract contract) throws Exception;

    String getToolHeart( ToolAlive toolAlive) throws Exception;

    int setToolHeart( ToolAlive toolAlive) throws Exception;

    int setContractTime( Contract contract) throws Exception;

    String  getContractTime( Contract contract) throws Exception;

    Contract getContractOperation( Contract contract) throws Exception;

    int setContractOperation( Contract contract) throws Exception;

    String getContractTimeAll() throws Exception;

}
