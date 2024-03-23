package com.countervalorantapex.contractmanagement.sys.mapper;

import com.countervalorantapex.contractmanagement.sys.entity.WeeklyReports;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Mapper
public interface WeeklyReportsMapper extends BaseMapper<WeeklyReports> {
    WeeklyReports getWeeklyReportById(int reportId);

//    WeeklyReports getChaxunById(int reportId);

    int insertWeeklyReport(WeeklyReports report);

    int updateWeeklyReport(WeeklyReports report);

    int deleteWeeklyReport(int reportId);

    List<WeeklyReports> findAll();

    Boolean setScore(int reportId, String reportComment, BigDecimal score);
}
