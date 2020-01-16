package com.intellisense.crud.dto;

import com.intellisense.crud.models.Action;
import lombok.ToString;

import java.util.List;

@ToString
public class ProjectDTO {

    private String name;
    private String description;
    private boolean completed;
    private List actions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List getActions() {
        return actions;
    }

    public void setActions(List actions) {
        this.actions = actions;
    }
}
