package com.personal.project.management.tool.ppmtool.services;

import com.personal.project.management.tool.ppmtool.domain.Project;
import com.personal.project.management.tool.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        //Logic

        return projectRepository.save(project);
    }

}
