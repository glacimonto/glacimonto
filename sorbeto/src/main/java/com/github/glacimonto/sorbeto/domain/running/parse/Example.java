package com.github.glacimonto.sorbeto.domain.running.parse;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;
import java.util.Objects;

public class Example {

  private final ExecutionRequestId executionRequestId;

  public Example(ExecutionRequestId executionRequestId) {
    this.executionRequestId = executionRequestId;
  }

  @Override
  public String toString() {
    return "Example{" +
      "executionRequestId=" + executionRequestId +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Example example = (Example) o;
    return executionRequestId.equals(example.executionRequestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(executionRequestId);
  }

}