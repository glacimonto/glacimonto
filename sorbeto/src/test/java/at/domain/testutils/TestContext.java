package at.domain.testutils;

import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import com.github.glacimonto.sorbeto.domain.running.parse.Step;

public class TestContext {

  public static String TEST_CASE;

  public static final Example SIMPLE_EXAMPLE = Example.builder()
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

}
