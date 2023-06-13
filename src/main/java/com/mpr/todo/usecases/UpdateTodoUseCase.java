package com.mpr.todo.usecases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mpr.todo.domain.ports.TodoRepository;
import com.mpr.todo.domain.ports.UseCase;
import com.mpr.todo.domain.todo.dto.TodoDTO;
import com.mpr.todo.presentation.dto.UpdateTodoDTO;

@Service
@Qualifier("UpdateTodoUseCase")
public class UpdateTodoUseCase implements UseCase<UpdateTodoDTO, TodoDTO> {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private static final Logger logger = LoggerFactory.getLogger(UpdateTodoUseCase.class);

  @Override
  public TodoDTO execute(UpdateTodoDTO updateTodoDTO) {
    final TodoDTO todo = todoRepository.findById(updateTodoDTO.id);

    todo.setIsDone(updateTodoDTO.isDone);

    TodoDTO updatedTodo = this.todoRepository.updateContent(todo);

    UpdateTodoUseCase.logger.info(String.format("Todo %s have been updated", updateTodoDTO.id));

    return updatedTodo;
  }

}
