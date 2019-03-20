package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import at.domain.testutils.TestContext;
import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.Sorbeto;
import com.github.glacimonto.sorbeto.domain.SorbetoImpl;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCaseExecutionStepDef {

  private Sorbeto sorbeto = new SorbetoImpl();
  private ExecutionRequestId executionRequestId;

  @Given("the following glacio test case")
  public void the_following_glacio_test_case(String glacioTestCase) {
    TestContext.TEST_CASE = glacioTestCase;
  }

  @When("it is executed")
  public void it_is_executed() {
    executionRequestId = sorbeto.execute(TestContext.TEST_CASE);
  }

  @Then("the execution succeed")
  public void the_execution_succeed() {
    TestCaseExecutionReport expectedReport = new TestCaseExecutionReport();
    TestCaseExecutionReport testCaseExecutionReport = sorbeto.follow(executionRequestId);
    assertThat(testCaseExecutionReport).isEqualToComparingFieldByField(expectedReport);
  }

}