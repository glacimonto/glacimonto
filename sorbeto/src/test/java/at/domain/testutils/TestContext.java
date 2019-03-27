package at.domain.testutils;

import com.github.glacimonto.sorbeto.domain.RawTestCase;
import com.github.glacimonto.sorbeto.domain.running.compose.ComposedStep;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutableStep;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.compose.StepId;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import com.github.glacimonto.sorbeto.domain.running.parse.Step;

public class TestContext {

  public static RawTestCase TEST_CASE;

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

  public static final ExecutionPlan SIMPLE_EXECUTION_PLAN = ExecutionPlan.builder()
    .forExample(SIMPLE_EXAMPLE)
    .planStep(
      ComposedStep.builder()
        .withId(new StepId(1))
        .sentence("When a success action is executed")
        .withProperty("blocking")
        .withSubStep(ExecutableStep.builder()
          .withId(new StepId(2))
          .withProperty("blocking")
          .withAction("success").build())
        .build()
    )
    .planStep(
      ComposedStep.builder()
        .withId(new StepId(3))
        .sentence("Then the execution succeed")
        .withProperty("blocking")
        .withSubStep(ExecutableStep.builder()
          .withId(new StepId(4))
          .withProperty("blocking")
          .withAction("success").build())
        .build()
    )
    .build();


}
