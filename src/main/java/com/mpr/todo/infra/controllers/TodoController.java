package com.mpr.todo.infra.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpr.todo.application.gateways.UseCase;
import com.mpr.todo.domain.Todo;
import com.mpr.todo.infra.controllers.dto.AddTodoDTO;
import com.mpr.todo.infra.controllers.dto.TodoDTO;
import com.mpr.todo.infra.controllers.dto.UpdateTodoDTO;
import com.mpr.todo.infra.controllers.mappers.TodoDTOMapper;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

  @Autowired
  private TodoDTOMapper todoDTOMapper;

  @Autowired
  private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

  @Autowired
  @Qualifier("AddTodoUsecase")
  private UseCase<Todo, Todo> insertUseCase;

  @Autowired
  @Qualifier("ListTodosUsecase")
  private UseCase<Void, List<Todo>> listUseCase;

  @Autowired
  @Qualifier("DeleteTodoUseCase")
  private UseCase<Long, Void> deletUseCase;

  @Autowired
  @Qualifier("GetTodoUseCase")
  private UseCase<Long, Todo> getUseCase;

  @Autowired
  @Qualifier("UpdateTodoUseCase")
  private UseCase<Todo, Todo> updateUseCase;

  @PostMapping()
  public TodoDTO insertTodo(@RequestBody() AddTodoDTO addTodoDTO) {
    Todo todo = todoDTOMapper.fromAddTodoDTO(addTodoDTO);
    Todo createdTodo = insertUseCase.execute(todo);
    return todoDTOMapper.toResponse(createdTodo);
  }

  @PutMapping()
  public TodoDTO updateContent(@RequestBody() UpdateTodoDTO updateTodoDTO) {
    Todo updateDTO = todoDTOMapper.fromUpdateTodoDTO(updateTodoDTO);
    Todo updatedTodo = this.updateUseCase.execute(updateDTO);
    return todoDTOMapper.toResponse(updatedTodo);

  }

  @GetMapping("{id}")
  public TodoDTO getTodo(@PathVariable("id") Long id) {
    Todo todo = getUseCase.execute(id);
    return todoDTOMapper.toResponse(todo);
  }

  @GetMapping()
  public List<TodoDTO> listTodos() {
    List<Todo> todoList = listUseCase.execute(null);
    return todoList.stream().map(todoDTOMapper::toResponse).collect(Collectors.toList());
  }

  @DeleteMapping("{id}")
  public void insertTodo(@PathVariable("id") Long id) {
    deletUseCase.execute(id);
    TodoController.logger.info("Todo deleted");
  }
}