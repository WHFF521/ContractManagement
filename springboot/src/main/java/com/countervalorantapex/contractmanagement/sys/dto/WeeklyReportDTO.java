package com.countervalorantapex.contractmanagement.sys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WeeklyReportDTO {

    private String reportComment;

    private BigDecimal score;
}
