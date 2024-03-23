package com.countervalorantapex.contractmanagement.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.countervalorantapex.contractmanagement.sys.dto.ContractTypesInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractTypesInfoDTOMapper extends BaseMapper<ContractTypesInfoDTO> {
    List<ContractTypesInfoDTO> getCustomersAndMoney();
}
