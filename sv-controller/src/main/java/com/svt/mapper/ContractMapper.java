package com.svt.mapper;

import com.svt.entity.Contract;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ContractMapper {
	List<Contract> listContract ( ) throws Exception;

	List<Contract> select ( Contract contract ) throws Exception;

	int update ( Contract contract ) throws Exception;


}
