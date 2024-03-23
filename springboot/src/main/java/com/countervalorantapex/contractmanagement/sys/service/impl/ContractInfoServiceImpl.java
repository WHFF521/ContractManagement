package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.countervalorantapex.contractmanagement.sys.entity.ContractInfo;
import com.countervalorantapex.contractmanagement.sys.mapper.ContractInfoMapper;
import com.countervalorantapex.contractmanagement.sys.service.IContractInfoService;
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
public class ContractInfoServiceImpl extends ServiceImpl<ContractInfoMapper, ContractInfo> implements IContractInfoService {
    @Autowired
    private ContractInfoMapper contractInfoMapper;

    @Override
    public void addContractInfo(ContractInfo contractInfo) {
        contractInfoMapper.addContractInfo(contractInfo);
    }
}
