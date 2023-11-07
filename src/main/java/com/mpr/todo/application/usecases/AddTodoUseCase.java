package com.mpr.todo.application.usecases;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mpr.todo.application.gateways.TodoGateway;
import com.mpr.todo.application.gateways.UseCase;
import com.mpr.todo.domain.Todo;

public class AddTodoUseCase implements UseCase<Todo, Todo> {

  private final TodoGateway todoGateway;

  public AddTodoUseCase(TodoGateway todoGateway) {
    this.todoGateway = todoGateway;
  }

  public Todo execute(Todo todo) {

    todo.setIsDone(false);
    todo.setCreatedAt(LocalDateTime.now());

    return this.todoGateway.insert(todo);

  }

}