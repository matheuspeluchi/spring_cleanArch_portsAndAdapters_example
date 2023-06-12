package com.mpr.todo.domain.todo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

  public Long id;
  public String title;
  public String description;
  public Boolean isDone;
  public LocalDateTime createdAt;
  public LocalDateTime updatedAt;
}