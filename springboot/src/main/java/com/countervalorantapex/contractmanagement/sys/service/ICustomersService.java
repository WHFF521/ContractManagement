package com.countervalorantapex.contractmanagement.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.countervalorantapex.contractmanagement.sys.dto.CustomerNameDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Customers;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
public interface ICustomersService extends IService<Customers> {
    Customers getCustomersByName(String name);
    IPage<Customers> findAllCustomers(Page<Customers> page);
    void  addCustomers(Customers customers)throws Exception;

    List<CustomerNameDTO> findAllCustomerNames();
    void updateCustomersByName(Customers customers);
}
