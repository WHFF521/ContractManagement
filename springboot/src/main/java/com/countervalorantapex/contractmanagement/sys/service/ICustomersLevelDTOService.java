package com.countervalorantapex.contractmanagement.sys.service;

import com.countervalorantapex.contractmanagement.sys.dto.CustomersLevelDTO;

import java.util.List;

public interface ICustomersLevelDTOService {
    List<CustomersLevelDTO> getLevelDistribution();
}
