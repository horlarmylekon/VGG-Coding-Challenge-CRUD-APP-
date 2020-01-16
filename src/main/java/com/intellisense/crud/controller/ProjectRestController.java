package com.intellisense.crud.controller;

import com.intellisense.crud.exception.ResourceNotFoundException;
import com.intellisense.crud.models.Project;
import com.intellisense.crud.repository.ProjectRepository;
import com.intellisense.crud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> list = projectService.getAllProjects();

        return new ResponseEntity<List<Project>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Project entity = projectService.getProjectById(id);

        return new ResponseEntity<Project>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/project")
    public ResponseEntity<Project> createOrUpdateEmployee(Project project)
            throws ResourceNotFoundException {
        Project updated = projectService.createOrUpdateProject(project);
        return new ResponseEntity<Project>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/project/{id}")
    public HttpStatus deleteProjectById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        projectService.deleteProjectById(id);
        return HttpStatus.FORBIDDEN;
    }
}
