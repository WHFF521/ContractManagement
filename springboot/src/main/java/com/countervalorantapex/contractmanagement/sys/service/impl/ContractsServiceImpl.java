package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.countervalorantapex.contractmanagement.sys.entity.Contracts;
import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.countervalorantapex.contractmanagement.sys.mapper.ContractsMapper;
import com.countervalorantapex.contractmanagement.sys.service.IContractsService;
import com.countervalorantapex.contractmanagement.sys.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Service
public class ContractsServiceImpl extends ServiceImpl<ContractsMapper, Contracts> implements IContractsService {
    @Autowired
    private ContractsMapper contractsMapper;
    @Override
    public List<Contracts> getContractByYear(Integer year, Integer state){
        Users users = TokenUtils.getCurrentUser();
//        System.out.println(users.getUserRole());
        if(users.getUserRole()==1){
            return contractsMapper.getContractByYear(year,state,users.getUserAccount());
        }
        else {
            return contractsMapper.getContractByYear(year,state,null);
        }

    }

//    @Override
//    public List<Contracts> getContract(Integer state, Integer year, String contractName) {
//        return contractsMapper.getContract(state, year, contractName);
//    }
    @Override
    public IPage<Contracts> findContractsByParameters(int state, String year, String contractName, long pageNo, long pageSize) {
        Page<Contracts> page = new Page<>(pageNo, pageSize);
        Users users = TokenUtils.getCurrentUser();
        String userAccount = users.getUserAccount();

        QueryWrapper<Contracts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", state);
        if (StringUtils.isNotBlank(year)) {
            queryWrapper.eq("YEAR(sign_date)", year);
        }
        if (StringUtils.isNotBlank(contractName)) {
            queryWrapper.like("contract_name", contractName);
        }
        if (users.getUserRole() == 1){
            queryWrapper.eq("user_account", userAccount);
        }
        return contractsMapper.selectPage(page, queryWrapper);
    }

    public void closeContract(String contractName) {

        contractsMapper.closeContract(contractName);
    }
    @Override
    public void addContract(Contracts contracts){
        contractsMapper.addContract(contracts);
    }
}
