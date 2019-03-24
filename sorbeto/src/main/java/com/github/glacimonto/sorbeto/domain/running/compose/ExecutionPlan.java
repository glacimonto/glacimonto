package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import java.util.Objects;

public class ExecutionPlan {

  public final ExecutionRequestId executionRequestId;

  public ExecutionPlan(ExecutionRequestId executionRequestId) {
    this.executionRequestId = executionRequestId;
  }

  @Override
  public String toString() {
    return "ExecutionPlan{" +
      "executionRequestId=" + executionRequestId +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExecutionPlan that = (ExecutionPlan) o;
    return executionRequestId.equals(that.executionRequestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(executionRequestId);
  }

}