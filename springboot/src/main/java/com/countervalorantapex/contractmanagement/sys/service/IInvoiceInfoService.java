package com.countervalorantapex.contractmanagement.sys.service;

import com.countervalorantapex.contractmanagement.sys.entity.InvoiceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
public interface IInvoiceInfoService extends IService<InvoiceInfo> {
    public void addInvoiceInfo(InvoiceInfo invoiceInfo);
    InvoiceInfo getInvoiceInfoByName(String name);

    void updateInvoiceInfoByName(InvoiceInfo invoiceInfo);
}
