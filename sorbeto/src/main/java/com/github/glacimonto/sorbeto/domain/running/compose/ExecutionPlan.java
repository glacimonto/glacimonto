package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;

public class ExecutionPlan {

  private final ExecutionRequestId executionRequestId;

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
  public int hashCode() {
    int hash = 17;
    if (executionRequestId != null) {
      hash = 31 * hash + executionRequestId.hashCode();
    }
    return hash;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ExecutionPlan))
      return false;
    ExecutionPlan other = (ExecutionPlan) o;

    return (this.executionRequestId == null && other.executionRequestId == null)
      || (this.executionRequestId != null && this.executionRequestId.equals(other.executionRequestId));
  }

}