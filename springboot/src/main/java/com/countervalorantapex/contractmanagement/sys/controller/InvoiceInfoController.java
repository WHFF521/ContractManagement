package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.sys.entity.Customers;
import com.countervalorantapex.contractmanagement.sys.entity.InvoiceInfo;
import com.countervalorantapex.contractmanagement.sys.service.IInvoiceInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/sys/invoiceInfo")
public class InvoiceInfoController {
    @Autowired
    private IInvoiceInfoService iInvoiceInfoService;
    @PostMapping(value = "/addInvoiceInfo")
    @ApiOperation(value = "addInvoiceInfo")
//    public void addInvoiceInfo(InvoiceInfo invoiceInfo){
//        iInvoiceInfoService.addInvoiceInfo(invoiceInfo);
//    }
    public ResponseEntity<?> addInvoiceInfo(@RequestBody InvoiceInfo invoiceInfo) {
        Map<String, String> response = new HashMap<>();
        try {
            // 调用服务层方法进行插入操作
            iInvoiceInfoService.addInvoiceInfo(invoiceInfo);
            response.put("message", "插入发票信息成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入发票信息失败");
        }
    }
    @GetMapping("/getInvoice")
    @ApiOperation("获取发票信息")
    public InvoiceInfo getInvoiceInfoByName(@RequestParam(value = "name") String name){
        return iInvoiceInfoService.getInvoiceInfoByName(name);
    }
    @PostMapping("/updateInvoice")
    public ResponseEntity<?> updateInvoice(@RequestBody InvoiceInfo invoiceInfo) {
        Map<String, String> response = new HashMap<>();
        try {
            // 调用服务层方法进行插入操作
            iInvoiceInfoService.updateInvoiceInfoByName(invoiceInfo);
            response.put("message", "更新发票信息成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新发票信息失败");
        }
    }

}