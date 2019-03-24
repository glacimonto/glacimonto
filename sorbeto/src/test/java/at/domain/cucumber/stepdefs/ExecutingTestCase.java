package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import at.domain.testutils.TestContext;
import com.github.glacimonto.sorbeto.domain.Sorbeto;
import com.github.glacimonto.sorbeto.domain.SorbetoImpl;
import com.github.glacimonto.sorbeto.domain.reporting.DefaultReporterImpl;
import com.github.glacimonto.sorbeto.domain.reporting.Reporter;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;
import com.github.glacimonto.sorbeto.domain.running.DefaultRunnerImpl;
import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.IRun;
import com.github.glacimonto.sorbeto.domain.running.compose.DefaultComposerImpl;
import com.github.glacimonto.sorbeto.domain.running.compose.ICompose;
import com.github.glacimonto.sorbeto.domain.running.parse.IParse;
import com.github.glacimonto.sorbeto.domain.running.parse.DefaultParserImpl;
import com.github.glacimonto.sorbeto.domain.running.schedule.DefaultSchedulerImpl;
import com.github.glacimonto.sorbeto.domain.running.schedule.ISchedule;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExecutingTestCase {

  private Sorbeto sorbeto;
  private ExecutionRequestId executionRequestId;

  @Before
  public void setup() {
    IParse parser = new DefaultParserImpl();
    ICompose composer = new DefaultComposerImpl();
    Reporter reporter = new DefaultReporterImpl();
    ISchedule scheduler = new DefaultSchedulerImpl(reporter);
    IRun engine = new DefaultRunnerImpl(parser, composer, scheduler);
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
    TestCaseExecutionReport expectedReport = new TestCaseExecutionReport(executionRequestId);
    TestCaseExecutionReport actualReport = sorbeto.follow(executionRequestId);
    assertThat(actualReport).isEqualTo(expectedReport);
  }

}
