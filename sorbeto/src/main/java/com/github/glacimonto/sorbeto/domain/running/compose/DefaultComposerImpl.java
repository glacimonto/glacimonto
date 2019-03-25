package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.running.parse.Example;

public class DefaultComposerImpl implements ICompose {

  @Override
  public ExecutionPlan compose(Example example) {
    return ExecutionPlan.builder()
      .forExample(example)
      .planStep(
        ComposedStep.builder()
          .withId(new StepId(1))
          .sentence("When a success action is executed")
          .withSubStep(ExecutableStep.builder()
            .withId(new StepId(2))
            .withAction("success").build())
          .build()
      )
      .planStep(
        ComposedStep.builder()
          .withId(new StepId(3))
          .sentence("Then the execution succeed")
          .withSubStep(ExecutableStep.builder()
            .withId(new StepId(4))
            .withAction("success").build())
          .build()
      )
      .build();
  }

}
