package com.countervalorantapex.contractmanagement.sys.service;

import com.countervalorantapex.contractmanagement.sys.entity.ContractPayment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
public interface IContractPaymentService extends IService<ContractPayment> {
    List<ContractPayment> getPaymentByContractName(String contractName);
    void addContractPayment(ContractPayment contractPayment);
}
