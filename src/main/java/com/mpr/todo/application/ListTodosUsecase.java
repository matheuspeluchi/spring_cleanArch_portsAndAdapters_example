package com.mpr.todo.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mpr.todo.domain.ports.TodoRepository;
import com.mpr.todo.domain.ports.UseCase;
import com.mpr.todo.domain.todo.dto.TodoDTO;

@Service
@Qualifier("ListTodosUsecase")
public class ListTodosUsecase implements UseCase<Void, List<TodoDTO>> {

  @Autowired
  private TodoRepository todoRepository;

  @Override
  public List<TodoDTO> execute(Void dto) {
    return todoRepository.findAll();
  }

}
