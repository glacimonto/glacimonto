package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;

public interface ICompose {

  ExecutionPlan compose(ExecutionRequestId executionRequestId, Example givenExample);

}
