package com.countervalorantapex.contractmanagement.sys.service;

import com.countervalorantapex.contractmanagement.sys.entity.ContractTypesInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
public interface IContractTypesInfoService extends IService<ContractTypesInfo> {
    public void addContractTypesInfo(ContractTypesInfo contractTypesInfo);
}
