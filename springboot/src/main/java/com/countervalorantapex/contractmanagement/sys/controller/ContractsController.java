package com.countervalorantapex.contractmanagement.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.countervalorantapex.contractmanagement.exception.response.Resp;
import com.countervalorantapex.contractmanagement.sys.entity.Contracts;
import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.countervalorantapex.contractmanagement.sys.service.IContractsService;
import com.countervalorantapex.contractmanagement.sys.utils.TokenUtils;
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
@RequestMapping("/sys/contracts")
public class ContractsController {
    @Autowired
    private IContractsService iContractsService;
    @GetMapping(value = "/getContractByYear")
    @ApiOperation(value = "通过年份获取（合同看板页面）合同接口")
    public Resp<List<Contracts>> getContractYear(@RequestParam(value = "year") Integer year, @RequestParam(value = "state") Integer state) {

        return Resp.success(iContractsService.getContractByYear(year,state));

    }

    @GetMapping(value = "/getContract")
    @ApiOperation(value = "我的合同页面接口")
    public Resp<IPage<Contracts>> findContractsByParameters(@RequestParam("state") int state,
                                                     @RequestParam(value = "year", required = false) String year,
                                                     @RequestParam(value = "contractName", required = false) String contractName,
                                                     @RequestParam("pageNo") long pageNo,
                                                     @RequestParam("pageSize") long pageSize) {
        return Resp.success(iContractsService.findContractsByParameters(state, year, contractName, pageNo, pageSize));
    }
    @PutMapping("/{contractName}")
    @ApiOperation(value = "关闭合同按钮")
    public Resp<Boolean> closeContracts(@PathVariable String contractName){
        iContractsService.closeContract(contractName);
        return Resp.success(true);
    }

    @PostMapping("/addContracts")
    @ApiOperation(value = "addContracts")
    public ResponseEntity<?> addContract(@RequestBody Contracts contracts) {
        try {
            Users users = TokenUtils.getCurrentUser();
            contracts.setUserAccount(users.getUserAccount());
            iContractsService.addContract(contracts);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入合同信息失败");
        }
    }

}
