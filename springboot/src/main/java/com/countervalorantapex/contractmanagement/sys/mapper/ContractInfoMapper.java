package com.countervalorantapex.contractmanagement.sys.mapper;

import com.countervalorantapex.contractmanagement.sys.entity.ContractInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Mapper
public interface ContractInfoMapper extends BaseMapper<ContractInfo> {
    //aci代表addContractInfo的缩写
    void addContractInfo(@Param("aci")ContractInfo contractInfo);
}
