package com.mpr.todo.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mpr.todo.domain.ports.TodoRepository;
import com.mpr.todo.domain.ports.UseCase;

@Service
@Qualifier("DeleteTodoUseCase")
public class DeleteTodoUseCase implements UseCase<Long, Void> {
  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private static final Logger logger = LoggerFactory.getLogger(DeleteTodoUseCase.class);

  @Override
  public Void execute(Long id) {
    todoRepository.deleteById(id);
    DeleteTodoUseCase.logger.info(String.format("Todo %s have been deleted", id));

    return null;
  }

}
