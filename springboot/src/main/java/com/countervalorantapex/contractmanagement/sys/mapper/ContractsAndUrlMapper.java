package com.countervalorantapex.contractmanagement.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.countervalorantapex.contractmanagement.sys.dto.ContractsAndUrlDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface ContractsAndUrlMapper extends BaseMapper<ContractsAndUrlDTO> {
    IPage<ContractsAndUrlDTO> getContractPage(Page<ContractsAndUrlDTO> page,
                                              @Param("state") Integer state,
                                              @Param("year") Integer year,
                                              @Param("contractName") String contractName,
                                              @Param("userAccount") String userAccount);
}

