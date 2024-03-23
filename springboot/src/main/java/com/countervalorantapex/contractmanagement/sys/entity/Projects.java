package com.countervalorantapex.contractmanagement.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName("projects")
public class Projects {
    @TableField("project_name")
    private String projectName;

    @TableField("customer_name")
    private String customerName;

    @TableField("contract_amount")
    private BigDecimal contractAmount;

    @TableField("importance_level")
    private int importanceLevel;

    @TableField("project_category")
    private String projectCategory;

    @TableField("project_type")
    private String projectType;

    @TableField("project_date")
    private Date projectDate;

    @TableField("project_progress")
    private String projectProgress;

    @TableField("project_status")
    private int projectStatus;

    @TableField("business_subdivision")
    private String businessSubdivision;

    public Projects() {
    }

    public Projects(String projectName, String customerName, BigDecimal contractAmount, int importanceLevel,
                    String projectCategory, String projectType, Date projectDate, String projectProgress,
                    int projectStatus, String businessSubdivision) {
        this.projectName = projectName;
        this.customerName = customerName;
        this.contractAmount = contractAmount;
        this.importanceLevel = importanceLevel;
        this.projectCategory = projectCategory;
        this.projectType = projectType;
        this.projectDate = projectDate;
        this.projectProgress = projectProgress;
        this.projectStatus = projectStatus;
        this.businessSubdivision = businessSubdivision;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public int getImportanceLevel() {
        return importanceLevel;
    }

    public void setImportanceLevel(int importanceLevel) {
        this.importanceLevel = importanceLevel;
    }

    public String getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Date getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(Date projectDate) {
        this.projectDate = projectDate;
    }

    public String getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(String projectProgress) {
        this.projectProgress = projectProgress;
    }

    public int getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getBusinessSubdivision() {
        return businessSubdivision;
    }

    public void setBusinessSubdivision(String businessSubdivision) {
        this.businessSubdivision = businessSubdivision;
    }
}
