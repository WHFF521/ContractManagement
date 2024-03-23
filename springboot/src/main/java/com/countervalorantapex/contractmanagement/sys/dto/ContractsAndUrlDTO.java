package com.countervalorantapex.contractmanagement.sys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ContractsAndUrlDTO {
    private String contractName;
    private BigDecimal contractTotal;
    private String customerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate signDate;
    private String contractContent;

}
