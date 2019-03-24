package com.github.glacimonto.sorbeto.domain.running.compose;

import java.util.Objects;

public class ExecutionPlan {

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    return o != null && getClass() == o.getClass();
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

}