package com.mpr.todo.infra.gateways;

import com.mpr.todo.domain.Todo;
import com.mpr.todo.infra.persistence.TodoEntity;

public class TodoEntityMapper {
  TodoEntity toEntity(Todo todo) {
    return TodoEntity.builder()
        .title(todo.getTitle())
        .description(todo.getDescription())
        .isDone(todo.getIsDone())
        .createdAt(todo.getCreatedAt())
        .updatedAt(todo.getUpdatedAt())
        .build();
  }

  Todo toDomainObj(TodoEntity todoEntity) {
    return Todo.builder()
        .id(todoEntity.getId())
        .title(todoEntity.getTitle())
        .description(todoEntity.getDescription())
        .isDone(todoEntity.getIsDone())
        .createdAt(todoEntity.getCreatedAt())
        .updatedAt(todoEntity.getUpdatedAt())
        .build();
  }

}
