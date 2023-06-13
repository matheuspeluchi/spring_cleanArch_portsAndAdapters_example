package com.mpr.todo.infra.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTodoDTO {
  public Long id;
  public Boolean isDone;

}