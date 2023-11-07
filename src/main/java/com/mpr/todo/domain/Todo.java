package com.mpr.todo.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
  private Long id;
  private String title;
  private String description;
  private Boolean isDone;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
