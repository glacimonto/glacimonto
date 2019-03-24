package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.running.parse.Example;

public class DefaultComposerImpl implements ICompose {

  @Override
  public ExecutionPlan compose(Example givenExample) {
    return new ExecutionPlan();
  }

}
