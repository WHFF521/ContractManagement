package com.countervalorantapex.contractmanagement.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.countervalorantapex.contractmanagement.sys.entity.Contracts;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
public interface IContractsService extends IService<Contracts> {
    List<Contracts> getContractByYear(Integer year,Integer state);

    IPage<Contracts> findContractsByParameters(int state, String year, String contractName, long pageNo, long pageSize);
    //List<Contracts> getContract(Integer state,Integer year,String contractName);
    void closeContract(String contractName);
    void addContract(Contracts contracts);
}
