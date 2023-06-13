package com.mpr.todo.domain.todo.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
  private Long id;
  private String title;
  private String description;
  private Boolean isDone;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
