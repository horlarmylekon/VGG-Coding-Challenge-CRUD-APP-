package com.intellisense.crud.controller;


import com.intellisense.crud.exception.ResourceNotFoundException;
import com.intellisense.crud.models.Action;
import com.intellisense.crud.models.Project;
import com.intellisense.crud.repository.ActionRepository;
import com.intellisense.crud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ActionRestController {

    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ProjectRepository projectRepository;

//    @GetMapping("/actions/{id}")
//    public List <Action> getAllActions(@RequestParam Long id) {
//        Optional<Project> project = projectRepository.findById(id)
//
//
//        if (Objects.nonNull(project)){
//            return actionRepository.findAll();
//        }else {
//            throw new ResourceNotFoundException();
//        }
//    }
//


}
