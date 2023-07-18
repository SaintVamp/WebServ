package com.svt.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.svt.entity.Contract;
import com.svt.entity.ToolAlive;
import com.svt.mapper.ContractMapper;
import com.svt.mapper.MybatisInit;
import com.svt.mapper.ToolAliveMapper;
import com.svt.service.ZukServ;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Lazy()
public class ZukServImpl extends MybatisInit implements ZukServ {
    private ContractMapper contractMapper;
    private ToolAliveMapper toolAliveMapper;

    @Override
    public String getAreaNum(Contract contract) throws Exception {
        try {
            // Contract contract1=new Contract("0","0","0","0","0","0","0");
            contractMapper = (ContractMapper) init("com.svt.mapper.ContractMapper");
            List<Contract> list = contractMapper.select(contract);
            StringBuilder r = new StringBuilder();
            for (Contract contract1 : list) {
                r.append(contract1.getId()).append(",");
            }
            return r.toString().replaceFirst(".$", "");
        } finally {
            mybatisTools.closeCurrentSqlSession();
        }
    }

    @Override
    public int setContractTime(Contract contract) throws Exception {
        try {
            contractMapper = (ContractMapper) init("com.svt.mapper.ContractMapper");
            return contractMapper.update(contract);
        } finally {
            mybatisTools.commitCurrentSqlSession();
            mybatisTools.closeCurrentSqlSession();
        }

    }

    public long getContractTime(Contract contract) throws Exception {
        try {
            Contract contract1 = new Contract(null, contract.getId(), null, 99, 0, null, null);
            contractMapper = (ContractMapper) init("com.svt.mapper.ContractMapper");
            List<Contract> contractList = contractMapper.select(contract1);
            return contractList.get(0).getTimestamp();
        } finally {
            mybatisTools.closeCurrentSqlSession();
        }
    }


    @Override
    public Contract getContractOperation(Contract contract) throws Exception {
        try {
            Contract contract1 = new Contract(null, contract.getId(), null, 0, 0, "", null);
            contractMapper = (ContractMapper) init("com.svt.mapper.ContractMapper");
            List<Contract> contractList = contractMapper.select(contract1);
            return contractList.get(0);
        } finally {
            mybatisTools.closeCurrentSqlSession();
        }
    }

    @Override
    public int setContractOperation(Contract contract) throws Exception {
        try {
            Contract contract1 = new Contract(null, contract.getId(), null, 0, 0, contract.getOperation(), null);
            contractMapper = (ContractMapper) init("com.svt.mapper.ContractMapper");
            return contractMapper.update(contract1);
        } finally {
            mybatisTools.closeCurrentSqlSession();
        }
    }

    @Override
    public String getContractTimeAll() throws Exception {
        try {
            Contract contract = new Contract("", null, "", 0, 0, null, null);
            contractMapper = (ContractMapper) init("com.svt.mapper.ContractMapper");
            List<Contract> contractList = contractMapper.select(contract);
            return JSONObject.toJSONString(contractList);
        } finally {
            mybatisTools.closeCurrentSqlSession();
        }

    }

    @Override
    public int setToolHeart(ToolAlive toolAlive) throws Exception {
        try {
            toolAliveMapper = (ToolAliveMapper) init("com.svt.mapper.ToolAliveMapper");
            int i;
            ToolAlive toolAlive1 = new ToolAlive(toolAlive.getToolName(), toolAlive.getCode(), null, null);
            if (toolAliveMapper.countParams(toolAlive1) > 0) {
                i = toolAliveMapper.update(toolAlive);
            } else {
                i = toolAliveMapper.insert(toolAlive);
            }
            return i;
        } finally {
            mybatisTools.commitCurrentSqlSession();
            mybatisTools.closeCurrentSqlSession();
        }
    }

    @Override
    public String getToolHeart(ToolAlive toolAlive) throws Exception {
        try {
            toolAliveMapper = (ToolAliveMapper) init("com.svt.mapper.ToolAliveMapper");
            List<ToolAlive> toolAliveList = toolAliveMapper.select(toolAlive);
            return toolAliveList.get(0).getTimestamp();
        } finally {
            mybatisTools.closeCurrentSqlSession();
        }
    }

}