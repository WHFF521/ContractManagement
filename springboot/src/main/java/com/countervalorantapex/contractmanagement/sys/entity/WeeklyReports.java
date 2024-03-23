package com.countervalorantapex.contractmanagement.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@TableName("weekly_reports")
@ApiModel(value = "WeeklyReports对象", description = "")
@Data
public class WeeklyReports implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "report_id", type = IdType.AUTO)
    private Integer reportId;

    private String managerAccount;

    private String supervisorName;

    private Integer reportStatus;

    private String reportComment;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate reportDate;

    private String attendanceStatus;

    private String workThisWeek;

    private String workNextWeek;

    private Integer deleteControl;

    private BigDecimal score;
//
//    public Integer getReportId() {
//        return reportId;
//    }

//    public void setReportId(Integer reportId) {
//        this.reportId = reportId;
//    }
//    public String getManagerAccount() {
//        return managerAccount;
//    }
//
//    public void setManagerAccount(String managerAccount) {
//        this.managerAccount = managerAccount;
//    }
//    public String getSupervisorAccount() {
//        return supervisorAccount;
//    }
//
//    public void setSupervisorAccount(String supervisorAccount) {
//        this.supervisorAccount = supervisorAccount;
//    }
//    public Integer getReportStatus() {
//        return reportStatus;
//    }
//
//    public void setReportStatus(Integer reportStatus) {
//        this.reportStatus = reportStatus;
//    }
//    public String getReportComment() {
//        return reportComment;
//    }
//
//    public void setReportComment(String reportComment) {
//        this.reportComment = reportComment;
//    }
//    public LocalDate getReportDate() {
//        return reportDate;
//    }
//
//    public void setReportDate(LocalDate reportDate) {
//        this.reportDate = reportDate;
//    }
//    public String getAttendanceStatus() {
//        return attendanceStatus;
//    }
//
//    public void setAttendanceStatus(String attendanceStatus) {
//        this.attendanceStatus = attendanceStatus;
//    }
//    public String getWorkThisWeek() {
//        return workThisWeek;
//    }
//
//    public void setWorkThisWeek(String workThisWeek) {
//        this.workThisWeek = workThisWeek;
//    }
//    public String getWorkNextWeek() {
//        return workNextWeek;
//    }
//
//    public void setWorkNextWeek(String workNextWeek) {
//        this.workNextWeek = workNextWeek;
//    }
//    public Integer getDeleteControl() {
//        return deleteControl;
//    }
//
//    public void setDeleteControl(Integer deleteControl) {
//        this.deleteControl = deleteControl;
//    }
//
//    @Override
//    public String toString() {
//        return "WeeklyReports{" +
//            "reportId=" + reportId +
//            ", managerAccount=" + managerAccount +
//            ", supervisorAccount=" + supervisorAccount +
//            ", reportStatus=" + reportStatus +
//            ", reportComment=" + reportComment +
//            ", reportDate=" + reportDate +
//            ", attendanceStatus=" + attendanceStatus +
//            ", workThisWeek=" + workThisWeek +
//            ", workNextWeek=" + workNextWeek +
//            ", deleteControl=" + deleteControl +
//        "}";
//    }
}
