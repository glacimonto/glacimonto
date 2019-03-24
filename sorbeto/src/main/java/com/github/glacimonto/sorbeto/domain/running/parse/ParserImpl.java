package com.github.glacimonto.sorbeto.domain.running.parse;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;

public class ParserImpl implements IParse {

  @Override
  public Example parse(ExecutionRequestId executionRequestId, String testCase) {
    return new Example(executionRequestId);
  }

}
