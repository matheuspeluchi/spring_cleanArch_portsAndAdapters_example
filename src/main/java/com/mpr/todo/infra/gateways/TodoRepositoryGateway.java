package com.mpr.todo.infra.gateways;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mpr.todo.application.gateways.TodoGateway;
import com.mpr.todo.domain.Todo;
import com.mpr.todo.infra.exceptions.NotFoundException;
import com.mpr.todo.infra.persistence.TodoEntity;
import com.mpr.todo.infra.persistence.TodoRepository;

@Service
public class TodoRepositoryGateway implements TodoGateway {

  private final TodoRepository todoRepository;
  private final TodoEntityMapper todoEntityMapper;

  public TodoRepositoryGateway(TodoRepository todoRepository, TodoEntityMapper todoEntityMapper) {
    this.todoRepository = todoRepository;
    this.todoEntityMapper = todoEntityMapper;
  }

  @Override
  public Todo insert(Todo todo) {
    TodoEntity todoEntity = todoEntityMapper.toEntity(todo);
    TodoEntity newTodo = todoRepository.save(todoEntity);
    return todoEntityMapper.toDomainObj(newTodo);

  }

  @Override
  public List<Todo> findAll() {
    List<TodoEntity> list = todoRepository.findAll();
    return list.stream().map(todoEntityMapper::toDomainObj).collect(Collectors.toList());
  }

  @Override
  public Todo findById(Long id) {
    TodoEntity todo = todoRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
    return todoEntityMapper.toDomainObj(todo);
  }

  @Override
  public void deleteById(Long id) {
    todoRepository.deleteById(id);
  }

  @Override
  public Todo updateContent(Todo todo) {
    TodoEntity todoEntity = todoEntityMapper.toEntity(todo);
    TodoEntity updatedTodo = todoRepository.save(todoEntity);
    return todoEntityMapper.toDomainObj(updatedTodo);
  }

}