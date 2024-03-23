package com.countervalorantapex.contractmanagement.sys.mapper;

import com.countervalorantapex.contractmanagement.sys.entity.Customers;
import com.countervalorantapex.contractmanagement.sys.entity.InvoiceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Mapper
public interface InvoiceInfoMapper extends BaseMapper<InvoiceInfo> {
    //aII代表addInvoiceInfo的缩写
    void addInvoiceInfo(@Param("aII")InvoiceInfo invoiceInfo);

    InvoiceInfo getInvoiceInfoByName(@Param("cName") String name);
    void updateInvoiceInfoByName(@Param("upI") InvoiceInfo invoiceInfo);
}
