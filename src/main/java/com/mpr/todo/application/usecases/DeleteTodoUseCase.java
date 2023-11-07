package com.mpr.todo.application.usecases;

import com.mpr.todo.application.gateways.TodoGateway;
import com.mpr.todo.application.gateways.UseCase;

public class DeleteTodoUseCase implements UseCase<Long, Void> {

  private final TodoGateway todoGateway;

  public DeleteTodoUseCase(TodoGateway todoGateway) {
    this.todoGateway = todoGateway;
  }

  @Override
  public Void execute(Long id) {
    todoGateway.deleteById(id);

    return null;
  }

}
