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
@TableName("payment_types")
@ApiModel(value = "PaymentTypes对象", description = "")
public class PaymentTypes implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer paymentTypeId;

    private String paymentTypeName;

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }
    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Override
    public String toString() {
        return "PaymentTypes{" +
            "paymentTypeId=" + paymentTypeId +
            ", paymentTypeName=" + paymentTypeName +
        "}";
    }
}
