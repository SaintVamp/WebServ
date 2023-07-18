package com.svt.mapper;

import com.svt.entity.Contract;

import java.util.List;

public interface ContractMapper {
    List<Contract> list() throws Exception;

    List<Contract> select(Contract contract) throws Exception;

    int update(Contract contract) throws Exception;


}
