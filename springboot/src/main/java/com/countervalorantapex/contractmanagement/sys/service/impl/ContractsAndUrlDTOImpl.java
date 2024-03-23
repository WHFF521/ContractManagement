package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.countervalorantapex.contractmanagement.sys.dto.ContractsAndUrlDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.countervalorantapex.contractmanagement.sys.mapper.ContractsAndUrlMapper;
import com.countervalorantapex.contractmanagement.sys.service.IContractsAndUrlDTOService;
import com.countervalorantapex.contractmanagement.sys.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractsAndUrlDTOImpl implements IContractsAndUrlDTOService {
    @Autowired
    private ContractsAndUrlMapper contractsAndUrlMapper;

//    public IPage<ContractsAndUrlDTO> getContractPage(Integer state, Integer year, String contractName, Page<ContractsAndUrlDTO> page) {
//        return contractsAndUrlMapper.getContractPage(page, state, year, contractName);
//    }

    @Override
    public IPage<ContractsAndUrlDTO> getContractPage(Integer state, Integer year, String contractName, Page<ContractsAndUrlDTO> page) {
        Users users = TokenUtils.getCurrentUser();
        if(users.getUserRole() == 1){
            return contractsAndUrlMapper.getContractPage(page, state, year, contractName,users.getUserAccount());
        }
        else {
            return contractsAndUrlMapper.getContractPage(page, state, year, contractName,null);
        }

    }
}
