package com.countervalorantapex.contractmanagement.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.countervalorantapex.contractmanagement.exception.response.Resp;
import com.countervalorantapex.contractmanagement.sys.dto.ContractsAndUrlDTO;
import com.countervalorantapex.contractmanagement.sys.service.IContractsAndUrlDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/contractsAndUrlDTO")
public class ContractsAndUrlDTOController {
    @Autowired
    private IContractsAndUrlDTOService iContractsAndUrlDTOService;

    @GetMapping("/getContracts")
    public Resp<IPage<ContractsAndUrlDTO>> getContracts(@RequestParam("state") Integer state,
                                                        @RequestParam(value = "year", required = false) Integer year,
                                                        @RequestParam(value = "contractName", required = false) String contractName,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<ContractsAndUrlDTO> page = new Page<>(pageNum, pageSize);
        return Resp.success(iContractsAndUrlDTOService.getContractPage(state, year, contractName, page));
    }
}
