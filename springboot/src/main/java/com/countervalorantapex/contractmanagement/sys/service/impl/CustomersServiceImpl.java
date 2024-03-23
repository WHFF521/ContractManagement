package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.countervalorantapex.contractmanagement.sys.dto.CustomerNameDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Customers;
import com.countervalorantapex.contractmanagement.sys.mapper.CustomersMapper;
import com.countervalorantapex.contractmanagement.sys.service.ICustomersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements ICustomersService {

    @Autowired
    private CustomersMapper customersMapper;
    @Override
    public Customers getCustomersByName(String name) {
        return customersMapper.getCustomersByName(name);
    }

    @Override
    public IPage<Customers> findAllCustomers(Page<Customers> page) {
        return customersMapper.findAllCustomers(page);
    }
    @Override
    public void addCustomers(Customers customers) throws Exception {
        if (customers.getCustomerName() == null || customers.getCustomerName().isEmpty()) {
            throw new Exception("客户名不能为空");
        }
        try {
            // 执行插入操作
            customersMapper.addCustomers(customers);
        } catch (Exception e) {
            throw new Exception("插入客户信息失败", e);
        }

    }

    @Override
    public List<CustomerNameDTO> findAllCustomerNames() {
        return customersMapper.findAllCustomerNames();
    }

    @Override
    public void updateCustomersByName(Customers customers) {
        customersMapper.updateCustomersByName(customers);
    }
}
