package com.mpr.todo.application.gateways;

public interface UseCase<I, O> {

  public O execute(I dto);

}