package com.mpr.todo.infra.adapters.repositories.todo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mpr.todo.domain.ports.TodoRepository;
import com.mpr.todo.domain.todo.dto.TodoDTO;
import com.mpr.todo.infra.adapters.entities.TodoEntity;
import com.mpr.todo.infra.adapters.repositories.jparepository.JpaTodoRepository;
import com.mpr.todo.infra.exceptions.NotFoundException;

@Service
public class DatabaseTodoRepository implements TodoRepository {

  @Autowired
  private JpaTodoRepository jpaRepository;

  @Override
  public TodoDTO insert(TodoDTO todo) {
    TodoEntity todoEntity = new TodoEntity(todo);
    TodoEntity newTodo = jpaRepository.save(todoEntity);
    return this.entityToDTO(newTodo);

  }

  @Override
  public List<TodoDTO> findAll() {
    List<TodoEntity> list = jpaRepository.findAll();
    return list.stream().map(this::entityToDTO).collect(Collectors.toList());
  }

  @Override
  public TodoDTO findById(Long id) {
    TodoEntity todo = jpaRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
    return this.entityToDTO(todo);
  }

  @Override
  public void deleteById(Long id) {
    jpaRepository.deleteById(id);
  }

  private TodoDTO entityToDTO(TodoEntity todoEntity) {
    TodoDTO dto = new TodoDTO();
    dto.setId(todoEntity.getId());
    dto.setTitle(todoEntity.getTitle());
    dto.setDescription(todoEntity.getDescription());
    dto.setIsDone(todoEntity.getIsDone());
    dto.setCreatedAt(todoEntity.getCreatedAt());
    dto.setUpdatedAt(todoEntity.getUpdatedAt());

    return dto;

  }

  @Override
  public TodoDTO updateContent(TodoDTO todo) {
    TodoEntity todoEntity = new TodoEntity(todo);
    TodoEntity updatedTodo = this.jpaRepository.save(todoEntity);
    return this.entityToDTO(updatedTodo);
  }

}