package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.countervalorantapex.contractmanagement.sys.entity.WeeklyReports;
import com.countervalorantapex.contractmanagement.sys.mapper.WeeklyReportsMapper;
import com.countervalorantapex.contractmanagement.sys.service.IWeeklyReportsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Service
public class WeeklyReportsServiceImpl extends ServiceImpl<WeeklyReportsMapper, WeeklyReports> implements IWeeklyReportsService {

    @Autowired
    private WeeklyReportsMapper reportMapper;
    @Override
    public WeeklyReports getWeeklyReportById(int reportId) {
        return reportMapper.getWeeklyReportById(reportId);
    }

//    public WeeklyReports getChaxunById(int reportId){return reportMapper.getChaxunById(reportId);}
    @Override
    public void createWeeklyReport(WeeklyReports report) {
        reportMapper.insertWeeklyReport(report);
    }
    @Override
    public void updateWeeklyReport(WeeklyReports report) {
        reportMapper.updateWeeklyReport(report);
    }
    @Override
    public void deleteWeeklyReport(int reportId) {
        reportMapper.deleteWeeklyReport(reportId);
    }

    public Boolean setScore(int reportId,String reportComment, BigDecimal score){
        if(reportMapper.setScore(reportId,reportComment,score)){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public List<WeeklyReports> findAll() {
        return reportMapper.findAll();
    }


}
