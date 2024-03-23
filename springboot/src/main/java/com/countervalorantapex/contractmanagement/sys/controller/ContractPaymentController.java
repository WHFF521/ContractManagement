package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.exception.response.Resp;
import com.countervalorantapex.contractmanagement.sys.entity.ContractPayment;
import com.countervalorantapex.contractmanagement.sys.service.IContractPaymentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/sys/contractPayment")
public class ContractPaymentController {
    @Autowired
    private IContractPaymentService iContractPaymentService;
    @GetMapping(value = "/getPaymentByContractName")
    @ApiOperation(value = "通过合同名称获取付款节点信息接口")
    public Resp<List<ContractPayment>> getPayment(@RequestParam(value = "contractName") String contractName){
        // jwt   json web token
        return Resp.success(iContractPaymentService.getPaymentByContractName(contractName));
    }
    @PostMapping("/addContractPayment")
    @ApiOperation(value = "addContractPayment")
    public ResponseEntity<?> addContractPayment(@RequestBody ContractPayment contractPayment) {
        try {
            iContractPaymentService.addContractPayment(contractPayment);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入合同支付信息失败");
        }
    }

}
