package com.countervalorantapex.contractmanagement.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@TableName("contract_payment")
@ApiModel(value = "ContractPayment对象", description = "")
@Data
public class ContractPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer paymentTypeId;

    private String contractName;

    private BigDecimal paymentAmount;

    private BigDecimal paymentPercent;

    private BigDecimal paymentNode;

    private String paymentTerms;

    private PaymentTypes paymentTypes;
    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }
    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public BigDecimal getPaymentPercent() {
        return paymentPercent;
    }

    public void setPaymentPercent(BigDecimal paymentPercent) {
        this.paymentPercent = paymentPercent;
    }
    public BigDecimal getPaymentNode() {
        return paymentNode;
    }

    public void setPaymentNode(BigDecimal paymentNode) {
        this.paymentNode = paymentNode;
    }
    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @Override
    public String toString() {
        return "ContractPayment{" +
            "paymentTypeId=" + paymentTypeId +
            ", contractName=" + contractName +
            ", paymentAmount=" + paymentAmount +
            ", paymentPercent=" + paymentPercent +
            ", paymentNode=" + paymentNode +
            ", paymentTerms=" + paymentTerms +
        "}";
    }
}
