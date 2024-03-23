package com.countervalorantapex.contractmanagement.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@ApiModel(value = "Contracts对象", description = "")

public class Contracts implements Serializable {

    private static final long serialVersionUID = 1L;

    private String contractName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate signDate;

    private BigDecimal contractTotal;

    private String contractContent;

    private Integer state;

    private String userAccount;

    public String getUserAccount(){ return userAccount; }
    public void setUserAccount(String userAccount){ this.userAccount = userAccount; }
    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }


    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }
    public BigDecimal getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(BigDecimal contractTotal) {
        this.contractTotal = contractTotal;
    }
    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Contracts{" +
            "contractName=" + contractName +
            ", signDate=" + signDate +
            ", contractTotal=" + contractTotal +
            ", contractContent=" + contractContent +
            ", state=" + state +
        "}";
    }
}
