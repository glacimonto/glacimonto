package com.github.glacimonto.sorbeto.domain.running.witness;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import java.util.Objects;

public class ExecutionReport {

  public final ExecutionRequestId executionRequestId;
  public final ExecutionId executionId;

  public ExecutionReport(ExecutionRequestId executionRequestId, ExecutionId executionId) {
    this.executionRequestId = executionRequestId;
    this.executionId = executionId;
  }

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