package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.sys.dto.ContractTypesInfoDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Customers;
import com.countervalorantapex.contractmanagement.sys.service.IContractTypesInfoDTOService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/ContractTypesInfoDTO")
public class ContractTypesInfoDTOController {
    @Autowired
    private IContractTypesInfoDTOService iContractTypesInfoDTOService;
    @GetMapping("/getCustomersAndMoney")
    @ApiOperation("获取所有用户和相关合同总金额")
    public List<ContractTypesInfoDTO> getCustomersAndMoney(){
        return iContractTypesInfoDTOService.getCustomersAndMoney();
    }
}
