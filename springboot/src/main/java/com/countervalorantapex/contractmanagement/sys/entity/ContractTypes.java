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
@TableName("contract_types")
@ApiModel(value = "ContractTypes对象", description = "")
public class ContractTypes implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer contractTypeId;

    private String contractTypeName;

    public Integer getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }
    public String getContractTypeName() {
        return contractTypeName;
    }

    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    @Override
    public String toString() {
        return "ContractTypes{" +
            "contractTypeId=" + contractTypeId +
            ", contractTypeName=" + contractTypeName +
        "}";
    }
}
