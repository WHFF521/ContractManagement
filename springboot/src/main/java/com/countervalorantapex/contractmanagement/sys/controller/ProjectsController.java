package com.countervalorantapex.contractmanagement.sys.controller;

import com.countervalorantapex.contractmanagement.sys.entity.Projects;
import com.countervalorantapex.contractmanagement.sys.service.impl.ProjectsServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/projects")
@MapperScan("com.countervalorantapex.contractmanagement.sys.mapper")
public class ProjectsController {

        private final ProjectsServiceImpl projectServiceImpl;
        @Autowired
        public ProjectsController(ProjectsServiceImpl projectServiceImpl) {
            this.projectServiceImpl = projectServiceImpl;
        }

        @GetMapping("/{projectName}")
        public Projects getProject(@PathVariable String projectName) {
            return projectServiceImpl.getProjectByName(projectName);
        }
}
