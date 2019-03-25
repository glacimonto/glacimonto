package com.github.glacimonto.sorbeto.domain.running.witness.event;

import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import java.util.Objects;

public final class NoEvent implements ExecutionEvent {

  private final ExecutionId executionId;

  public NoEvent(ExecutionId executionId) {
    this.executionId = executionId;
  }

  @Override
  public ExecutionId executionId() {
    return this.executionId;
  }

  @Override
  public String type() {
    return "NO_EVENT";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    return o != null && getClass() == o.getClass();
  }

  @Override
  public int hashCode() {
    return Objects.hash(type());
  }

}