package com.mpr.todo.infra.persistence;

import java.time.LocalDateTime;

import com.mpr.todo.infra.controllers.dto.TodoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
@Entity
public class TodoEntity {

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