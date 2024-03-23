package com.countervalorantapex.contractmanagement.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@TableName("invoice_info")
@ApiModel(value = "InvoiceInfo对象", description = "")
public class InvoiceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String customerName;

    private String companyName;

    private String taxNumber;

    private String phone;

    private String address;

    private String bankName;

    private String bankAccount;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "InvoiceInfo{" +
            "customerName=" + customerName +
            ", companyName=" + companyName +
            ", taxNumber=" + taxNumber +
            ", phone=" + phone +
            ", address=" + address +
            ", bankName=" + bankName +
            ", bankAccount=" + bankAccount +
        "}";
    }
}
