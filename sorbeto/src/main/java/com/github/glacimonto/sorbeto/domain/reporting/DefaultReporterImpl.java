package com.github.glacimonto.sorbeto.domain.reporting;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.witness.ExecutionReport;
import java.util.HashMap;
import java.util.Map;

public class DefaultReporterImpl implements Reporter {

  private final Map<ExecutionRequestId, TestCaseExecutionReport> reports = new HashMap<>();

  @Override
  public TestCaseExecutionReport follow(ExecutionRequestId executionRequestId) {
    return reports.get(executionRequestId);
  }

  @Override
  public void record(ExecutionReport report) {
    reports.put(report.executionRequestId, update(report));
  }

  private TestCaseExecutionReport update(ExecutionReport report) {
    return new TestCaseExecutionReport(report.executionRequestId);
  }

}
