package com.intellisense.crud.service;

import com.intellisense.crud.exception.ResourceNotFoundException;
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

    public Project getProjectById(Long id) throws ResourceNotFoundException
    {
        Optional<Project> project = projectRepository.findById(id);

        if(project.isPresent()) {
            return project.get();
        } else {
            throw new ResourceNotFoundException("No Project record exist for given id");
        }
    }

    public Project createOrUpdateProject(Project project) throws ResourceNotFoundException
    {
        Optional<Project> projectOptional = projectRepository.findById(project.getId());

        if(projectOptional.isPresent())
        {
            Project newEntity = projectOptional.get();
            newEntity.setName(project.getName());
            newEntity.setDescription(project.getDescription());
            newEntity.setActions(project.getActions());

            newEntity = projectRepository.save(newEntity);

            return newEntity;
        } else {
            project = projectRepository.save(project);
            return project;
        }
    }

    public void deleteProjectById(Long id) throws ResourceNotFoundException
    {
        Optional<Project> project = projectRepository.findById(id);

        if(project.isPresent())
        {
            projectRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No Project record exist for given id");
        }
    }
}
