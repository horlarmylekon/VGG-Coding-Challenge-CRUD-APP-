package com.intellisense.crud.service;

import com.intellisense.crud.exception.RecordNotFoundException;
import com.intellisense.crud.models.Action;
import com.intellisense.crud.models.Project;
import com.intellisense.crud.repository.ActionRepository;
import com.intellisense.crud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public List<Action> getAllActions()
    {
        List<Action> actionList = actionRepository.findAll();

        if(actionList.size() > 0) {
            return actionList;
        } else {
            return new ArrayList<Action>();
        }
    }

    public Action getActionById(Long id) throws RecordNotFoundException
    {
        Optional<Action> actionOptional = actionRepository.findById(id);

        if(actionOptional.isPresent()) {
            return actionOptional.get();
        } else {
            throw new RecordNotFoundException("No action record exist for given id");
        }
    }

    public Action createOrAction(@PathVariable Long id) throws RecordNotFoundException
    {
        Optional<Project> project = projectRepository.findById(id);

        if(project.isPresent())
        {
            Action newAction = new Action();
//            newAction.setDescription(project.getName());

            newAction = actionRepository.save(newAction);

            return newAction;
        } else {
            throw new RecordNotFoundException("No project record exist for given id");
        }
    }

    public void deleteActionById(Long id) throws RecordNotFoundException
    {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if(optionalProject.isPresent())
        {
            actionRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No action record exist for given id");
        }
    }
}
