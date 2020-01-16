package com.intellisense.crud.dto;

import com.intellisense.crud.models.Project;
import lombok.ToString;

@ToString
public class ActionDTO {

    private Project project;
    private String description;
    private String notes;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
