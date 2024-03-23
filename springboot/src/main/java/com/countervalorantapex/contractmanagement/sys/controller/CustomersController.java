package com.countervalorantapex.contractmanagement.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.countervalorantapex.contractmanagement.exception.response.Resp;
import com.countervalorantapex.contractmanagement.sys.dto.CustomerNameDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Customers;
import com.countervalorantapex.contractmanagement.sys.service.ICustomersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@RestController
@CrossOrigin
@RequestMapping("/sys/customers")
public class CustomersController {
    @Autowired
    private ICustomersService iCustomersService;

    @GetMapping("/getcustomer")
    @ApiOperation("获取客户信息")
    public Customers getcustomers(@RequestParam(value = "name") String name){
        return  iCustomersService.getCustomersByName(name);
    }

    @GetMapping("/findallcustomers")
    @ApiOperation("获取所有用户信息")
    public Resp<IPage<Customers>> findAllCustomers(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        Page<Customers> page = new Page<>(pageNum,pageSize);
        return Resp.success(iCustomersService.findAllCustomers(page));
    }
    @GetMapping("/names")
    public List<CustomerNameDTO> getCustomerNames() {
        return iCustomersService.findAllCustomerNames();
    }
    @PostMapping("/addCustomer")
    @ApiOperation(value = "addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customers customers) {
        try {
            Map<String, String> response = new HashMap<>();
            // 调用服务层方法进行插入操作
            iCustomersService.addCustomers(customers);
            response.put("message", "插入客户信息成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入客户信息失败");
        }
    }
    @PostMapping("/updateCustomer")
    @ApiOperation("updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody Customers customers) {
        Map<String, String> response = new HashMap<>();
        try {
            // 调用服务层方法进行插入操作
            iCustomersService.updateCustomersByName(customers);
            response.put("message", "更新客户信息成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新客户信息失败");
        }
    }
}
