package com.mpr.todo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mpr.todo.domain.ports.TodoRepository;
import com.mpr.todo.domain.ports.UseCase;
import com.mpr.todo.domain.todo.dto.TodoDTO;

@Service
@Qualifier("GetTodoUseCase")
public class GetTodoUseCase implements UseCase<Long, TodoDTO> {
  @Autowired
  private TodoRepository todoRepository;

  @Override
  public TodoDTO execute(Long id) {
    return todoRepository.findById(id);
  }

}
