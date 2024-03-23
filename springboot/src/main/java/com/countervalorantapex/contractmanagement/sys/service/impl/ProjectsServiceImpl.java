package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.countervalorantapex.contractmanagement.sys.entity.Projects;
import com.countervalorantapex.contractmanagement.sys.mapper.ProjectsMapper;
import com.countervalorantapex.contractmanagement.sys.service.IProjectsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServiceImpl extends ServiceImpl<ProjectsMapper, Projects> implements IProjectsService {
        private final ProjectsMapper projectsMapper;

        public ProjectsServiceImpl(ProjectsMapper projectsMapper) {
            this.projectsMapper = projectsMapper;
        }

        public Projects getProjectByName(String projectName) {
            return projectsMapper.findByProjectName(projectName);
        }
}
