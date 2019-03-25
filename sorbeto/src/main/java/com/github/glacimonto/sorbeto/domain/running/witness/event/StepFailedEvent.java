package com.github.glacimonto.sorbeto.domain.running.witness.event;

import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import java.util.Objects;

public class StepFailedEvent implements StepExecutionEvent {

  private final ExecutionId executionId;

  public StepFailedEvent(ExecutionId executionId) {
    this.executionId = executionId;
  }

  @Override
  public ExecutionId executionId() {
    return this.executionId;
  }

  @Override
  public String type() {
    return "STEP_FAILED_EVENT";
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
