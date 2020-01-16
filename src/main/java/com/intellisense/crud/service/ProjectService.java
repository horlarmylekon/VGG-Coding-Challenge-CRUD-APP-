package com.intellisense.crud.service;

import com.intellisense.crud.exception.RecordNotFoundException;
import com.intellisense.crud.models.Project;
import com.intellisense.crud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects()
    {
        List<Project> projectList = projectRepository.findAll();

        if(projectList.size() > 0) {
            return projectList;
        } else {
            return new ArrayList<Project>();
        }
    }

    public Project getProjectById(Long id) throws RecordNotFoundException
    {
        Optional<Project> projectOptional = projectRepository.findById(id);

        if(projectOptional.isPresent()) {
            return projectOptional.get();
        } else {
            throw new RecordNotFoundException("No project record exist for given id");
        }
    }

    public Project createOrUpdateProject(Project project) throws RecordNotFoundException
    {
        Optional<Project> projectOptional = projectRepository.findById(project.getId());

        if(projectOptional.isPresent())
        {
            Project newProject = new Project();
//            newProject.setName(projectOptional.getName());
//            newProject.setDescription(projectOptional.getDescription());
//            newProject.setActions(projectOptional.setActions());
//            newProject.setCompleted(projectOptional.getCompleted);

            newProject = projectRepository.save(newProject);

            return newProject;
        } else {
            project = projectRepository.save(project);

            return project;
        }
    }

    public void deleteProjectById(Long id) throws RecordNotFoundException
    {
        Optional<Project> projectOptional = projectRepository.findById(id);

        if(projectOptional.isPresent())
        {
            projectRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No project record exist for given id");
        }
    }
}
