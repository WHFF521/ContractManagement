package com.countervalorantapex.contractmanagement.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@TableName("contract_info")
@ApiModel(value = "ContractInfo对象", description = "")
@Data
public class ContractInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String contractName;

    private String customerName;

    private String accountManagerName;

    private String contractNumber;

    private String bg;

    private String bu;

    private String industry;

    private String subIndustry;

    private String projectType;

    private String region;

    private String institution;

    private String province;

    private String productLine;

    private String partyB;

    private String currency;

    private String grossMargin;

    private String priceList;

    private Boolean performanceBonds;

    private String other;

    private Integer typeNumber;

    private String maintenancePeriod;

    private BigDecimal rateTotal;

    private String signingStatus;
    
    private String paymentMethod;



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getAccountManagerName() {
        return accountManagerName;
    }

    public void setAccountManagerName(String accountManagerName) {
        this.accountManagerName = accountManagerName;
    }
    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }
    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getSubIndustry() {
        return subIndustry;
    }

    public void setSubIndustry(String subIndustry) {
        this.subIndustry = subIndustry;
    }
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }
    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(String grossMargin) {
        this.grossMargin = grossMargin;
    }
    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }
    public Boolean getPerformanceBonds() {
        return performanceBonds;
    }

    public void setPerformanceBonds(Boolean performanceBonds) {
        this.performanceBonds = performanceBonds;
    }
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
    public Integer getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(Integer typeNumber) {
        this.typeNumber = typeNumber;
    }
    public String getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public void setMaintenancePeriod(String maintenancePeriod) {
        this.maintenancePeriod = maintenancePeriod;
    }
    public BigDecimal getRateTotal() {
        return rateTotal;
    }

    public void setRateTotal(BigDecimal rateTotal) {
        this.rateTotal = rateTotal;
    }
    public String getSigningStatus() {
        return signingStatus;
    }

    public void setSigningStatus(String signingStatus) {
        this.signingStatus = signingStatus;
    }    
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "ContractInfo{" +
                "contractName=" + contractName +
            ", customerName=" + customerName +
            ", accountManagerName=" + accountManagerName +
            ", contractNumber=" + contractNumber +
            ", bg=" + bg +
            ", bu=" + bu +
            ", industry=" + industry +
            ", subIndustry=" + subIndustry +
            ", projectType=" + projectType +
            ", region=" + region +
            ", institution=" + institution +
            ", province=" + province +
            ", productLine=" + productLine +
            ", partyB=" + partyB +
            ", currency=" + currency +
            ", grossMargin=" + grossMargin +
            ", priceList=" + priceList +
            ", performanceBonds=" + performanceBonds +
            ", other=" + other +
            ", typeNumber=" + typeNumber +
            ", maintenancePeriod=" + maintenancePeriod +
            ", rateTotal=" + rateTotal +
            ", signingStatus=" + signingStatus +
            ", paymentMethod" + paymentMethod +
        "}";
    }
}
