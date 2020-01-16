package com.intellisense.crud.controller;

import com.intellisense.crud.exception.ResourceNotFoundException;
import com.intellisense.crud.models.Project;
import com.intellisense.crud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProjectRestController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List < Project > getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/project/{id}")
    public ResponseEntity < Project > getPrjectById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
        return ResponseEntity.ok().body(project);
    }

    @PostMapping("/projects")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity < Project > updateProject(@PathVariable(value = "id") Long projectId,
                                                      @Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setActions(projectDetails.getActions());
        final Project updatedProject = projectRepository.save(project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/projects/{id}")
    public Map< String, Boolean > deleteProject(@PathVariable(value = "id") Long projectId)
            throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

        projectRepository.delete(project);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
