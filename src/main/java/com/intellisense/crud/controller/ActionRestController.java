package com.intellisense.crud.controller;

import com.intellisense.crud.exception.RecordNotFoundException;
import com.intellisense.crud.models.Action;
import com.intellisense.crud.models.Project;
import com.intellisense.crud.repository.ActionRepository;
import com.intellisense.crud.service.ActionService;
import com.intellisense.crud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ActionRestController {

    @Autowired
    private ActionService actionService;
    @Autowired
    private ProjectService projectService;


    @DeleteMapping("/project/action/{id}")
    public HttpStatus deleteActionById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        actionService.deleteActionById(id);
        return HttpStatus.FORBIDDEN;
    }


}
