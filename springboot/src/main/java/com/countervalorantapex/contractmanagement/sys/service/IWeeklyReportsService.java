package com.countervalorantapex.contractmanagement.sys.service;

import com.countervalorantapex.contractmanagement.sys.entity.WeeklyReports;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
public interface IWeeklyReportsService extends IService<WeeklyReports> {

    public WeeklyReports getWeeklyReportById(int reportId);

//    public WeeklyReports getChaxunById(int reportId);

//    public WeeklyReports getPingfenById(int reportId);

    public void createWeeklyReport(WeeklyReports report);

    public void updateWeeklyReport(WeeklyReports report);

    Boolean setScore(int reportId,String reportComment, BigDecimal score);
    public void deleteWeeklyReport(int reportId);
    public List<WeeklyReports> findAll();
}
