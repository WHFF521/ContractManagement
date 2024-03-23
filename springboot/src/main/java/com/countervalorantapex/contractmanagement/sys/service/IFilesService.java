package com.countervalorantapex.contractmanagement.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.countervalorantapex.contractmanagement.sys.entity.Files;

public interface IFilesService extends IService<Files> {
    Files getFileByName(String fileName);
    Integer deleteFileByName(String fileName);
}
