package com.countervalorantapex.contractmanagement.sys.mapper;

import com.countervalorantapex.contractmanagement.sys.dto.ContractsAndUrlDTO;
import com.countervalorantapex.contractmanagement.sys.entity.Contracts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface ContractsMapper extends BaseMapper<Contracts> {
    List<Contracts> getContractByYear(@Param("year") Integer year,@Param("state") Integer state,@Param("userAccount") String userAccount);
    List<ContractsAndUrlDTO> getContract(@Param("state") Integer state,
                                         @Param("year") Integer year,
                                         @Param("contractName") String contractName,
                                         @Param("userAccount") String userAccount);
    void addContract(@Param("ac")Contracts contracts);
    void closeContract(@Param("contractName") String contractName);
}
