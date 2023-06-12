package com.mpr.todo.domain.ports;

import java.util.List;

import com.mpr.todo.domain.todo.dto.TodoDTO;

public interface TodoRepository {
  public TodoDTO insert(TodoDTO todo);

  public List<TodoDTO> findAll();

  public TodoDTO findById(Long id);

  public void deleteById(Long id);
}
