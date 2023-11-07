package com.mpr.todo.application.usecases;

import com.mpr.todo.application.gateways.TodoGateway;
import com.mpr.todo.application.gateways.UseCase;
import com.mpr.todo.domain.Todo;

public class GetTodoUseCase implements UseCase<Long, Todo> {

  private final TodoGateway todoGateway;

  public GetTodoUseCase(TodoGateway todoGateway) {
    this.todoGateway = todoGateway;
  }

  @Override
  public Todo execute(Long id) {
    return todoGateway.findById(id);
  }

}
