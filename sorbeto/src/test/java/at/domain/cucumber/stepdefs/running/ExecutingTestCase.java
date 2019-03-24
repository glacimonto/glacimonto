package at.domain.cucumber.stepdefs.running;

import static org.assertj.core.api.Assertions.assertThat;

import at.domain.testutils.TestContext;
import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.Sorbeto;
import com.github.glacimonto.sorbeto.domain.SorbetoImpl;
import com.github.glacimonto.sorbeto.domain.reporting.DefaultReporterImpl;
import com.github.glacimonto.sorbeto.domain.reporting.IReport;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;
import com.github.glacimonto.sorbeto.domain.running.DefaultRunnerImpl;
import com.github.glacimonto.sorbeto.domain.running.IRun;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExecutingTestCase {

  private Sorbeto sorbeto;
  private ExecutionRequestId executionRequestId;

  @Before
  public void setup() {
    IRun engine = new DefaultRunnerImpl();
    IReport reporter = new DefaultReporterImpl();
    sorbeto = new SorbetoImpl(engine, reporter);
  }

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
    TestCaseExecutionReport actualReport = sorbeto.follow(executionRequestId);
    assertThat(actualReport).isEqualTo(expectedReport);
  }

}
