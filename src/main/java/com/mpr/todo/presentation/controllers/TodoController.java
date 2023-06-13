package com.mpr.todo.presentation.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mpr.todo.domain.ports.UseCase;
import com.mpr.todo.domain.todo.dto.TodoDTO;
import com.mpr.todo.presentation.dto.AddTodoDTO;
import com.mpr.todo.presentation.dto.UpdateTodoDTO;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
  @Autowired
  private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

  @Autowired
  @Qualifier("AddTodoUsecase")
  private UseCase<AddTodoDTO, TodoDTO> insertUseCase;

  @Autowired
  @Qualifier("ListTodosUsecase")
  private UseCase<Void, List<TodoDTO>> listUseCase;

  @Autowired
  @Qualifier("DeleteTodoUseCase")
  private UseCase<Long, Void> deletUseCase;

  @Autowired
  @Qualifier("GetTodoUseCase")
  private UseCase<Long, TodoDTO> getUseCase;

  @Autowired
  @Qualifier("UpdateTodoUseCase")
  private UseCase<UpdateTodoDTO, TodoDTO> updateUseCase;

  @PostMapping()
  public TodoDTO insertTodo(@RequestBody() AddTodoDTO addTodoDTO) {
    return insertUseCase.execute(addTodoDTO);
  }

  @PutMapping()
  public TodoDTO updateContent(@RequestBody() UpdateTodoDTO updateTodoDTO) {
    return this.updateUseCase.execute(updateTodoDTO);
  }

  @GetMapping("{id}")
  public TodoDTO getTodo(@PathVariable("id") Long id) {
    return getUseCase.execute(id);
  }

  @GetMapping()
  public List<TodoDTO> listTodos() {
    return listUseCase.execute(null);
  }

  @DeleteMapping("{id}")
  public void insertTodo(@PathVariable("id") Long id) {
    deletUseCase.execute(id);
    TodoController.logger.info("Todo deleted");
  }
}