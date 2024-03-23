package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.sys.entity.ContractTypesInfo;
import com.countervalorantapex.contractmanagement.sys.service.IContractTypesInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/sys/contractTypesInfo")

public class ContractTypesInfoController {

    @Autowired
    private IContractTypesInfoService iContractTypesInfoService;
    @PostMapping("/addContractTypesInfo")
    @ApiOperation(value = "addContractTypesInfo")
    public ResponseEntity<?> addContractTypesInfo(@RequestBody ContractTypesInfo contractTypesInfo) {
        try {
            iContractTypesInfoService.addContractTypesInfo(contractTypesInfo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入合同类型信息失败");
        }
    }
}
