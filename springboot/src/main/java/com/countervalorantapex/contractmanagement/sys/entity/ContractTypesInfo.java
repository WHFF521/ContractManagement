package com.countervalorantapex.contractmanagement.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("contract_types_info")
@ApiModel(value = "ContractTypesInfo对象", description = "")
public class ContractTypesInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String contractName;

    private Integer contractTypeId;

    private BigDecimal amount;

    private BigDecimal rate;

    private BigDecimal taxRate;

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
    public Integer getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return "ContractTypesInfo{" +
            "contractName=" + contractName +
            ", contractTypeId=" + contractTypeId +
            ", amount=" + amount +
            ", rate=" + rate +
            ", taxRate=" + taxRate +
        "}";
    }
}
