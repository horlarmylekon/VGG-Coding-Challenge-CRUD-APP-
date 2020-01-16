package com.intellisense.crud.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "action_table")
public class Action {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    private Project project;
    private String description;
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", project=" + project +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
