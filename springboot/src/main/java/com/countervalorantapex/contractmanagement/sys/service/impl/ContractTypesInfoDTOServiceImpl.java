package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.countervalorantapex.contractmanagement.sys.dto.ContractTypesInfoDTO;
import com.countervalorantapex.contractmanagement.sys.dto.ContractsAndUrlDTO;
import com.countervalorantapex.contractmanagement.sys.mapper.ContractTypesInfoDTOMapper;
import com.countervalorantapex.contractmanagement.sys.service.IContractTypesInfoDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypesInfoDTOServiceImpl implements IContractTypesInfoDTOService {
    @Autowired
    private ContractTypesInfoDTOMapper contractTypesInfoDTOMapper;

    @Override
    public List<ContractTypesInfoDTO> getCustomersAndMoney(){
        return contractTypesInfoDTOMapper.getCustomersAndMoney();
    }
}
