package com.mpr.todo.application.gateways;

import java.util.List;

import com.mpr.todo.domain.Todo;

public interface TodoGateway {
  public Todo insert(Todo todo);

  public List<Todo> findAll();

  public Todo findById(Long id);

  public void deleteById(Long id);

  public Todo updateContent(Todo todo);
}
