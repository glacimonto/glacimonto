package at.domain.glacio.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import at.domain.testutils.TestContext;
import com.github.fridujo.glacio.running.api.Given;
import com.github.fridujo.glacio.running.api.Then;
import com.github.fridujo.glacio.running.api.When;
import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.Sorbeto;
import com.github.glacimonto.sorbeto.domain.SorbetoImpl;
import com.github.glacimonto.sorbeto.domain.reporting.DefaultReporterImpl;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;
import com.github.glacimonto.sorbeto.domain.running.DefaultRunnerImpl;

public class ExecutingTestCase {

/*  private Sorbeto sorbeto = new SorbetoImpl(new DefaultRunnerImpl(), new DefaultReporterImpl());

  private ExecutionRequestId executionRequestId;

  @Given("the following glacio test case")
  public void the_following_glacio_test_case(String glacioTestCase) {
    TestContext.TEST_CASE = glacioTestCase;
  }

  @When("it is executed")
  public void it_is_executed() {
    executionRequestId = sorbeto.run(TestContext.TEST_CASE);
  }

  @Then("the execution succeed")
  public void the_execution_succeed() {
    TestCaseExecutionReport expectedReport = new TestCaseExecutionReport();
    TestCaseExecutionReport testCaseExecutionReport = sorbeto.follow(executionRequestId);
    assertThat(testCaseExecutionReport).isEqualToComparingFieldByField(expectedReport);
  }*/
}