package com.github.glacimonto.sorbeto.domain;

import com.github.glacimonto.sorbeto.domain.running.IRun;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;

public class SorbetoImpl implements Sorbeto {

  private IRun engine;

  public SorbetoImpl(IRun engine) {
    this.engine = engine;
  }

  @Override
  public ExecutionRequestId run(String scenario) {
    return engine.run(scenario);
  }

  @Override
  public TestCaseExecutionReport follow(ExecutionRequestId executionRequestId) {
    return null;
  }

}
