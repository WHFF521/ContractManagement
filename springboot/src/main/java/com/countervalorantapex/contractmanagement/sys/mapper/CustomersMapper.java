package com.countervalorantapex.contractmanagement.sys.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.countervalorantapex.contractmanagement.sys.dto.CustomerNameDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Customers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Mapper
public interface CustomersMapper extends BaseMapper<Customers> {
    Customers getCustomersByName(@Param("customersName") String name);
    IPage<Customers> findAllCustomers(Page<Customers> page);
    void addCustomers(@Param("addcustomers") Customers customers);

    List<CustomerNameDTO> findAllCustomerNames();

    void updateCustomersByName(@Param("upC")Customers customers);
}
