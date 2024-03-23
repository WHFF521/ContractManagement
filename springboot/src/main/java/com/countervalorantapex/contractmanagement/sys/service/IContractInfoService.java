package com.countervalorantapex.contractmanagement.sys.service;

import com.countervalorantapex.contractmanagement.sys.entity.ContractInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
public interface IContractInfoService extends IService<ContractInfo> {
    public void addContractInfo(ContractInfo contractInfo);
}
