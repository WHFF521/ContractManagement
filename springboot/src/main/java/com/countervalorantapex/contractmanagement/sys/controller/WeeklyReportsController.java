package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.exception.response.Resp;
import com.countervalorantapex.contractmanagement.sys.dto.WeeklyReportDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Customers;
import com.countervalorantapex.contractmanagement.sys.entity.WeeklyReports;
import com.countervalorantapex.contractmanagement.sys.service.IWeeklyReportsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/api/weekly-reports")
public class WeeklyReportsController {
    @Autowired
    private IWeeklyReportsService reportService;

    @GetMapping("/{reportId}")
    public ResponseEntity<?> getWeeklyReportById(@PathVariable int reportId) {
        WeeklyReports report = reportService.getWeeklyReportById(reportId);
        if (report != null) {
            return ResponseEntity.ok(report);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addWeeklyReport")
    @ApiOperation(value = "createWeeklyReport")
    public ResponseEntity<?> createWeeklyReport(@RequestBody WeeklyReports report) {
        try {
            // 调用服务层方法进行插入操作
            reportService.createWeeklyReport(report);
            Map<String, String> response = new HashMap<>();
            response.put("message", "插入周报成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入周报失败");
        }
    }

    @PutMapping("/setScore/{reportId}")
    public Resp<Boolean> setScore(@PathVariable int reportId, @RequestBody WeeklyReportDTO weeklyReportDTO){
        return Resp.success(reportService.setScore(reportId,weeklyReportDTO.getReportComment(),weeklyReportDTO.getScore()));
    }


    @PutMapping("/{reportId}")
    public ResponseEntity<String> updateWeeklyReport(@PathVariable int reportId, @RequestBody WeeklyReports report) {
        WeeklyReports existingReport = reportService.getWeeklyReportById(reportId);
        if (existingReport != null) {
            report.setReportId(reportId);
            reportService.updateWeeklyReport(report);
            return ResponseEntity.ok("Weekly report updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<String> deleteWeeklyReport(@PathVariable int reportId) {
        WeeklyReports existingReport = reportService.getWeeklyReportById(reportId);
        if (existingReport != null) {
            reportService.deleteWeeklyReport(reportId);
            return ResponseEntity.ok("Weekly report deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findall")
    @ApiOperation("获取所有周报信息")
    public List<WeeklyReports> findall(){
        return reportService.findAll();
    }

}
