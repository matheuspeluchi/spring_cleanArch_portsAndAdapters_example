package com.mpr.todo.infra.adapters.entities;

import java.time.LocalDateTime;

import com.mpr.todo.domain.todo.dto.TodoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
@Entity
public class TodoEntity {

  public TodoEntity(TodoDTO todo) {
    this.id = todo.id;
    this.title = todo.title;
    this.description = todo.description;
    this.isDone = todo.isDone;
    this.createdAt = todo.createdAt;
    this.updatedAt = todo.updatedAt;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "desciption")
  private String description;

  @Column(name = "isCompleted", nullable = false)
  private Boolean isDone;

  @Column(name = "createdAt", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "completedAt")
  private LocalDateTime updatedAt;
}