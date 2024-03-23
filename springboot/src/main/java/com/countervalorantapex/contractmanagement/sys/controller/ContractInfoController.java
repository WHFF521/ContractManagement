package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.sys.entity.ContractInfo;
import com.countervalorantapex.contractmanagement.sys.service.IContractInfoService;
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
@RequestMapping("/sys/contractInfo")
public class ContractInfoController {
    @Autowired
    private IContractInfoService iContractInfoService;
    @PostMapping("/addContractInfo")
    @ApiOperation(value = "addContractInfo")
    public ResponseEntity<?> addContractInfo(@RequestBody ContractInfo contractInfo) {
        try {
            iContractInfoService.addContractInfo(contractInfo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入合同信息失败");
        }
    }
}