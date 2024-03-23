package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.countervalorantapex.contractmanagement.sys.entity.ContractTypesInfo;
import com.countervalorantapex.contractmanagement.sys.mapper.ContractTypesInfoMapper;
import com.countervalorantapex.contractmanagement.sys.service.IContractTypesInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Service
public class ContractTypesInfoServiceImpl extends ServiceImpl<ContractTypesInfoMapper, ContractTypesInfo> implements IContractTypesInfoService {
    @Autowired
    private ContractTypesInfoMapper contractTypesInfoMapper;
    @Override
    public void addContractTypesInfo(ContractTypesInfo contractTypesInfo){
        contractTypesInfoMapper.addContractTypesInfo(contractTypesInfo);
    }
}
