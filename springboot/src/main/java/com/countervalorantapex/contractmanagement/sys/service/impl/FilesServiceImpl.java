package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.countervalorantapex.contractmanagement.sys.entity.Files;
import com.countervalorantapex.contractmanagement.sys.mapper.FilesMapper;
import com.countervalorantapex.contractmanagement.sys.service.IFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper,Files> implements IFilesService {
    @Autowired
    private FilesMapper filesMapper;

    @Override
    public Files getFileByName(String fileName) {
        return filesMapper.getFilesByName(fileName);
    }

    public Integer deleteFileByName(String fileName) {
        Integer deleteRows=filesMapper.deleteFilesByName(fileName);
        return deleteRows;
    }
}
