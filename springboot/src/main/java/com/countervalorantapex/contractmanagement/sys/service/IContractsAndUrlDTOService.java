package com.countervalorantapex.contractmanagement.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.countervalorantapex.contractmanagement.sys.dto.ContractsAndUrlDTO;

public interface IContractsAndUrlDTOService {
    IPage<ContractsAndUrlDTO> getContractPage(Integer state, Integer year, String contractName, Page<ContractsAndUrlDTO> page);
}
