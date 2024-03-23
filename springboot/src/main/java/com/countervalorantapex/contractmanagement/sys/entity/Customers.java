package com.countervalorantapex.contractmanagement.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@TableName("customers")
@ApiModel(value = "Customers对象", description = "")
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;

    private String customerName;

    private String customerLevel;

    private String industry;

    private String postalCode;

    private String province;

    private String city;

    private String county;

    private String address;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers{" +
            "customerName=" + customerName +
            ", customerLevel=" + customerLevel +
            ", industry=" + industry +
            ", postalCode=" + postalCode +
            ", province=" + province +
            ", city=" + city +
            ", county=" + county +
            ", address=" + address +
        "}";
    }
}
