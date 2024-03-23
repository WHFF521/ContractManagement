package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.countervalorantapex.contractmanagement.sys.entity.InvoiceInfo;
import com.countervalorantapex.contractmanagement.sys.mapper.InvoiceInfoMapper;
import com.countervalorantapex.contractmanagement.sys.service.IInvoiceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Service
public class InvoiceInfoServiceImpl extends ServiceImpl<InvoiceInfoMapper, InvoiceInfo> implements IInvoiceInfoService {
    @Autowired
    private InvoiceInfoMapper invoiceInfoMapper;
    @Override
    public void addInvoiceInfo(InvoiceInfo invoiceInfo) {
        invoiceInfoMapper.addInvoiceInfo(invoiceInfo);
    }

    @Override
    public InvoiceInfo getInvoiceInfoByName(String name) {
        return invoiceInfoMapper.getInvoiceInfoByName(name);
    }

    @Override
    public void updateInvoiceInfoByName(InvoiceInfo invoiceInfo) {
        invoiceInfoMapper.updateInvoiceInfoByName(invoiceInfo);
    }
}
