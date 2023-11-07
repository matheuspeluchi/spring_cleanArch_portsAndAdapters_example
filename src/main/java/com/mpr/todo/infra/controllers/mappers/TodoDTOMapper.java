package com.mpr.todo.infra.controllers.mappers;

import com.mpr.todo.domain.Todo;
import com.mpr.todo.infra.controllers.dto.AddTodoDTO;
import com.mpr.todo.infra.controllers.dto.TodoDTO;
import com.mpr.todo.infra.controllers.dto.UpdateTodoDTO;

public class TodoDTOMapper {
  public TodoDTO toResponse(Todo todo) {
    return TodoDTO.builder()
        .id(todo.getId())
        .title(todo.getTitle())
        .description(todo.getDescription())
        .isDone(todo.getIsDone())
        .createdAt(todo.getCreatedAt())
        .updatedAt(todo.getUpdatedAt())
        .build();

  }

  public Todo fromAddTodoDTO(AddTodoDTO todo) {
    return Todo.builder()
        .title(todo.getTitle())
        .description(todo.getDescription())
        .build();

  }

  public Todo fromUpdateTodoDTO(UpdateTodoDTO todo) {
    return Todo.builder()
        .id(todo.getId())
        .isDone(todo.getIsDone())
        .build();

  }

}
