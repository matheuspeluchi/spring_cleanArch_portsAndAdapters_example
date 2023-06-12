package com.mpr.todo.infra.adapters.repositories.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpr.todo.infra.adapters.entities.TodoEntity;

public interface JpaTodoRepository extends JpaRepository<TodoEntity, Long> {

}
