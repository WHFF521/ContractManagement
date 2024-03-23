package com.countervalorantapex.contractmanagement.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.countervalorantapex.contractmanagement.sys.entity.Files;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FilesMapper extends BaseMapper<Files> {
    Files getFilesByName(@Param("fileName") String fileName);
    Integer deleteFilesByName(@Param("fileName") String fileName);
}
