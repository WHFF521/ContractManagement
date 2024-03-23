package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.countervalorantapex.contractmanagement.sys.entity.ContractPayment;
import com.countervalorantapex.contractmanagement.sys.mapper.ContractPaymentMapper;
import com.countervalorantapex.contractmanagement.sys.service.IContractPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Service
public class ContractPaymentServiceImpl extends ServiceImpl<ContractPaymentMapper, ContractPayment> implements IContractPaymentService {
    @Autowired
    private ContractPaymentMapper contractPaymentMapper;

    @Override
    public List<ContractPayment> getPaymentByContractName(String contractName) {
        return contractPaymentMapper.getPaymentByContractName(contractName);
    }
    @Override
    public void addContractPayment(ContractPayment contractPayment) {
        contractPaymentMapper.addComtractPayment(contractPayment);
    }
}

