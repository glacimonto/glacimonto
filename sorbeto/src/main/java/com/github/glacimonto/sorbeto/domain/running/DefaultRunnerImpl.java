package com.github.glacimonto.sorbeto.domain.running;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;

public class DefaultRunnerImpl implements IRun {

  private Parser parser;

  @Override
  public ExecutionRequestId run(String testCase) {
    Example example = parser.parse(testCase);
    return generateExecutionId();
  }

  private ExecutionRequestId generateExecutionId() {
    return new ExecutionRequestId(0L);
  }

}
