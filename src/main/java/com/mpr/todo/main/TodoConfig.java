package com.mpr.todo.main;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.QueryAnnotation;

import com.mpr.todo.application.gateways.TodoGateway;
import com.mpr.todo.application.usecases.AddTodoUseCase;
import com.mpr.todo.application.usecases.DeleteTodoUseCase;
import com.mpr.todo.application.usecases.GetTodoUseCase;
import com.mpr.todo.application.usecases.ListTodosUsecase;
import com.mpr.todo.application.usecases.UpdateTodoUseCase;
import com.mpr.todo.infra.controllers.mappers.TodoDTOMapper;
import com.mpr.todo.infra.gateways.TodoEntityMapper;
import com.mpr.todo.infra.gateways.TodoRepositoryGateway;
import com.mpr.todo.infra.persistence.TodoRepository;

@Configuration
public class TodoConfig {

  @Bean
  TodoGateway todoGateway(TodoRepository todoRepository, TodoEntityMapper todoEntityMapper) {
    return new TodoRepositoryGateway(todoRepository, todoEntityMapper);
  }

  @Bean
  TodoDTOMapper todoDTOMapper() {
    return new TodoDTOMapper();
  }

  @Bean
  TodoEntityMapper todoEntityMapper() {
    return new TodoEntityMapper();
  }

  @Bean
  @Qualifier("AddTodoUsecase")
  AddTodoUseCase addTodoUseCase(TodoGateway todoGateway) {
    return new AddTodoUseCase(todoGateway);
  }

  @Bean
  @Qualifier("DeleteTodoUseCase")
  DeleteTodoUseCase deleteTodoUseCase(TodoGateway todoGateway) {
    return new DeleteTodoUseCase(todoGateway);
  }

  @Bean
  @Qualifier("GetTodoUseCase")
  GetTodoUseCase getTodoUseCase(TodoGateway todoGateway) {
    return new GetTodoUseCase(todoGateway);
  }

  @Bean
  @Qualifier("ListTodosUsecase")
  ListTodosUsecase listTodosUsecase(TodoGateway todoGateway) {
    return new ListTodosUsecase(todoGateway);
  }

  @Bean
  @Qualifier("UpdateTodoUseCase")
  UpdateTodoUseCase updateTodoUseCase(TodoGateway todoGateway) {
    return new UpdateTodoUseCase(todoGateway);
  }

}
