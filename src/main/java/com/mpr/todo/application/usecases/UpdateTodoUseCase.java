package com.mpr.todo.application.usecases;

import com.mpr.todo.application.gateways.TodoGateway;
import com.mpr.todo.application.gateways.UseCase;
import com.mpr.todo.domain.Todo;

public class UpdateTodoUseCase implements UseCase<Todo, Todo> {

  private final TodoGateway todoGateway;

  public UpdateTodoUseCase(TodoGateway todoGateway) {
    this.todoGateway = todoGateway;
  }

  @Override
  public Todo execute(Todo updateTodo) {
    final Todo todo = todoGateway.findById(updateTodo.getId());

    todo.setIsDone(updateTodo.getIsDone());

    return this.todoGateway.updateContent(todo);

  }

}
