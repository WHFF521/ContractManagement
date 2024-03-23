package com.countervalorantapex.contractmanagement.sys.mapper;

import com.countervalorantapex.contractmanagement.sys.entity.ContractPayment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Mapper
public interface ContractPaymentMapper extends BaseMapper<ContractPayment> {
    public List<ContractPayment> getPaymentByContractName(@Param("contractName") String contractName);
    void addComtractPayment(@Param("acp")ContractPayment contractPayment);
}
