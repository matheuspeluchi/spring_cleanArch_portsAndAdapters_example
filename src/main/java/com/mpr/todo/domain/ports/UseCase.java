package com.mpr.todo.domain.ports;

public interface UseCase<I, O> {

  public O execute(I dto);

}