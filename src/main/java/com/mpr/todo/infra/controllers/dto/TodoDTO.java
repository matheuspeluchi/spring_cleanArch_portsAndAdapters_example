package com.mpr.todo.infra.controllers.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDTO {

  public Long id;
  public String title;
  public String description;
  public Boolean isDone;
  public LocalDateTime createdAt;
  public LocalDateTime updatedAt;
}