package com.personal.project.management.tool.ppmtool.services;

import com.personal.project.management.tool.ppmtool.domain.Backlog;
import com.personal.project.management.tool.ppmtool.domain.ProjectTask;
import com.personal.project.management.tool.ppmtool.repositories.BacklogRepository;
import com.personal.project.management.tool.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {


    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;


    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){

        //Exceptions: Project not found

        //PTs to be added to a specific project, project != null, BL exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        //set the bl to pt
        projectTask.setBacklog(backlog);
        //we want our project sequence to be like this: IDPRO-1  IDPRO-2  ...100 101
        Integer backlogSequence = backlog.getPTSequence();
        // Update the BL SEQUENCE
        backlogSequence++;

        //Add Sequence to Project Task
        projectTask.setProjectSequence(projectIdentifier+"-"+backlogSequence);
        projectTask.setProjectIdentifer(projectIdentifier);

        //INITIAL priority when priority null
        if(projectTask.getPriority()==null){ //In the future we need projectTask.getPriority()== 0 to handle the form
            projectTask.setPriority(3);
        }

        //INITIAL status when status is null
        if(projectTask.getStatus()==""|| projectTask.getStatus()==null){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }
}