package com.intellisense.crud.repository;

import com.intellisense.crud.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {


}
