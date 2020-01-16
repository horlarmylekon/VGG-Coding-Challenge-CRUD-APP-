package com.intellisense.crud.controller;

import com.intellisense.crud.models.Action;
import com.intellisense.crud.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActionRestController {

    @Autowired
    private ActionRepository actionRepository;

    @GetMapping("/actions")
    public List<Action> retrieveAllActions() {
        return actionRepository.findAll();
    }
}
