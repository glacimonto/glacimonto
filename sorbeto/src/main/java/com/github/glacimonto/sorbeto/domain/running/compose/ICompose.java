package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.running.parse.Example;

public interface ICompose {

  ExecutionPlan compose(Example givenExample);

}
