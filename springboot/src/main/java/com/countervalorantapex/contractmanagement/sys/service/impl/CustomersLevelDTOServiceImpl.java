package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.countervalorantapex.contractmanagement.sys.dto.CustomersLevelDTO;
import com.countervalorantapex.contractmanagement.sys.mapper.CustomersLevelDTOMapper;
import com.countervalorantapex.contractmanagement.sys.service.ICustomersLevelDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersLevelDTOServiceImpl implements ICustomersLevelDTOService {
    @Autowired
    private CustomersLevelDTOMapper customersLevelDTOMapper;
    @Override
    public List<CustomersLevelDTO> getLevelDistribution() {
        return customersLevelDTOMapper.getLevelDistribution();
    }
}
