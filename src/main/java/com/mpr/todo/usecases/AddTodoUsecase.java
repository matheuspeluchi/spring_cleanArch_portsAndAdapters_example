package com.mpr.todo.usecases;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mpr.todo.domain.ports.TodoRepository;
import com.mpr.todo.domain.ports.UseCase;
import com.mpr.todo.domain.todo.dto.TodoDTO;
import com.mpr.todo.domain.todo.models.Todo;
import com.mpr.todo.presentation.dto.AddTodoDTO;

@Service
@Qualifier("AddTodoUsecase")
public class AddTodoUsecase implements UseCase<AddTodoDTO, TodoDTO> {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private static final Logger logger = LoggerFactory.getLogger(AddTodoUsecase.class);

  public TodoDTO execute(AddTodoDTO addTodoDTO) {
    Todo todo = new Todo();
    todo.setTitle(addTodoDTO.title);
    todo.setDescription(addTodoDTO.description);
    todo.setIsDone(false);
    todo.setCreatedAt(LocalDateTime.now());

    TodoDTO persistTodo = new TodoDTO();

    persistTodo.setTitle(todo.getTitle());
    persistTodo.setDescription(todo.getDescription());
    persistTodo.setIsDone(todo.getIsDone());
    persistTodo.setCreatedAt(todo.getCreatedAt());

    TodoDTO newTodo = this.todoRepository.insert(persistTodo);
    AddTodoUsecase.logger.info("New todo have been inserted");
    return newTodo;
  }

}