package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;

public class DefaultComposerImpl implements ICompose {

  @Override
  public ExecutionPlan compose(ExecutionRequestId executionRequestId, Example givenExample) {
    return new ExecutionPlan(executionRequestId);
  }

}
