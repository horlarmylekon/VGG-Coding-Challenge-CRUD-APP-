package com.intellisense.crud.repository;

import com.intellisense.crud.models.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}
