package com.github.glacimonto.sorbeto.domain;

import com.github.glacimonto.sorbeto.domain.reporting.IReport;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;
import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.IRun;

public class SorbetoImpl implements Sorbeto {

  private final IRun engine;
  private final IReport reporter;

  public SorbetoImpl(IRun engine, IReport reporter) {
    this.engine = engine;
    this.reporter = reporter;
  }

  @Override
  public ExecutionRequestId run(RawTestCase testCase) {
    return engine.run(testCase);
  }

  @Override
  public TestCaseExecutionReport follow(ExecutionRequestId executionRequestId) {
    return reporter.follow(executionRequestId);
  }

}
