package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.sys.dto.ContractTypesInfoDTO;
import com.countervalorantapex.contractmanagement.sys.dto.CustomersLevelDTO;
import com.countervalorantapex.contractmanagement.sys.service.ICustomersLevelDTOService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/CustomersLevelDTO")
public class CustomersLevelDTOController {
    @Autowired
    private ICustomersLevelDTOService iCustomersLevelDTOService;

    @GetMapping("/getLevelDistribution")
    @ApiOperation("获取用户级别和当前级别数量")
    List<CustomersLevelDTO> getLevelDistribution(){
        return iCustomersLevelDTOService.getLevelDistribution();
    }
}
