package com.countervalorantapex.contractmanagement.sys.mapper;

import com.countervalorantapex.contractmanagement.sys.dto.CustomersLevelDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomersLevelDTOMapper {
    List<CustomersLevelDTO> getLevelDistribution();
}
