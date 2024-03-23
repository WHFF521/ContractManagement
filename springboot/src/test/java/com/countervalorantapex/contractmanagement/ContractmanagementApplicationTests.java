package com.countervalorantapex.contractmanagement;

import com.countervalorantapex.contractmanagement.sys.entity.ContractTypes;
import com.countervalorantapex.contractmanagement.sys.mapper.ContractTypesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ContractmanagementApplicationTests {

    @Resource
    private ContractTypesMapper contractTypesMapper;
    @Test
    void contextLoads() {
        List<ContractTypes> contractTypes=contractTypesMapper.selectList(null);
        contractTypes.forEach(System.out::println);
    }

}
