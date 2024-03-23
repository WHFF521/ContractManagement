package com.countervalorantapex.contractmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.countervalorantapex.contractmanagement.*.mapper")
public class ContractmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractmanagementApplication.class, args);
    }

}
