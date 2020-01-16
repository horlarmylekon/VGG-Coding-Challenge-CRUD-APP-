package com.intellisense.crud.controller;

import com.intellisense.crud.exception.RecordNotFoundException;
import com.intellisense.crud.models.Project;
import com.intellisense.crud.repository.ProjectRepository;
import com.intellisense.crud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> list = projectService.getAllProjects();

        return new ResponseEntity<List<Project>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("project/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Project entity = projectService.getProjectById(id);

        return new ResponseEntity<Project>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/project/update")
    public ResponseEntity<Project> createOrUpdateProject(Project project)
            throws RecordNotFoundException {
        Project updated = projectService.createOrUpdateProject(project);
        return new ResponseEntity<Project>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/project/{id}")
    public HttpStatus deleteProjectById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        projectService.deleteProjectById(id);
        return HttpStatus.FORBIDDEN;
    }

}
