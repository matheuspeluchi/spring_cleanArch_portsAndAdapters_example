package com.mpr.todo.application.usecases;

import java.util.List;

import com.mpr.todo.application.gateways.TodoGateway;
import com.mpr.todo.application.gateways.UseCase;
import com.mpr.todo.domain.Todo;

public class ListTodosUsecase implements UseCase<Void, List<Todo>> {

  private final TodoGateway todoGateway;

  public ListTodosUsecase(TodoGateway todoGateway) {
    this.todoGateway = todoGateway;
  }

  @Override
  public List<Todo> execute(Void dto) {
    return todoGateway.findAll();
  }

}
