package com.github.glacimonto.sorbeto.domain.reporting;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import java.util.Objects;

public class TestCaseExecutionReport {

  private final ExecutionRequestId executionRequestId;

  public TestCaseExecutionReport(ExecutionRequestId executionRequestId) {
    this.executionRequestId = executionRequestId;
  }

  @Override
  public String toString() {
    return "TestCaseExecutionReport{" +
      "executionRequestId=" + executionRequestId +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TestCaseExecutionReport that = (TestCaseExecutionReport) o;
    return executionRequestId.equals(that.executionRequestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(executionRequestId);
  }
}