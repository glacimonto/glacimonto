package at.cucumber.domain.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.Sorbeto;
import com.github.glacimonto.sorbeto.domain.SorbetoImpl;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCaseExecutionStepDef {

  private Sorbeto sorbeto = new SorbetoImpl();
  private String glacioTestCase;
  private ExecutionRequestId executionRequestId;

  @Given("the following glacio test case")
  public void theFollowingGlacioTestCase(String glacioTestCase) {
    this.glacioTestCase = glacioTestCase;
  }

  @When("it is executed")
  public void itIsExecuted() {
    executionRequestId = sorbeto.execute(glacioTestCase);
  }

  @Then("the execution succeed")
  public void theExecutionSucceed() {
    TestCaseExecutionReport expectedReport = new TestCaseExecutionReport();
    TestCaseExecutionReport testCaseExecutionReport = sorbeto.follow(executionRequestId);
    assertThat(testCaseExecutionReport).isEqualToComparingFieldByField(expectedReport);
  }

}
