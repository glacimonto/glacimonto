package com.github.glacimonto.sorbeto.domain.running.parse;

import com.github.glacimonto.sorbeto.domain.RawTestCase;

public class DefaultParserImpl implements IParse {

  private Example hardCodedExample = Example.builder()
    .forFeature("Fake Glacio test case")
    .forScenario("Fake scenario")
    .withSteps(
      Step.builder().sentence("When a success action is executed")
        .withSubStep(Step.builder().sentence("Do success").build()).build()
      ,
      Step.builder().sentence("Then the execution succeed")
        .withSubStep(Step.builder().sentence("Do success").build()).build()
    )
    .build();

  @Override
  public Example parse(RawTestCase testCase) {
    return hardCodedExample;
  }

}
