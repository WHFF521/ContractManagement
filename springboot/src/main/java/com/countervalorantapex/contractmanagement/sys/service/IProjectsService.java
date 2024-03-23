package com.countervalorantapex.contractmanagement.sys.service;

import com.countervalorantapex.contractmanagement.sys.entity.Projects;
import com.baomidou.mybatisplus.extension.service.IService;
import com.countervalorantapex.contractmanagement.sys.mapper.ProjectsMapper;


public interface IProjectsService extends IService<Projects> {
    public Projects getProjectByName(String projectName);
}
