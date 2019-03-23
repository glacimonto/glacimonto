package at.domain.cucumber.stepdefs;

import com.github.glacimonto.sorbeto.domain.reporting.DefaultReporterImpl;
import com.github.glacimonto.sorbeto.domain.reporting.IReport;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.witness.ITell;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

public class ReportingTestCase {

  private ScheduledExecution givenRunningExecution;
  private ITell testWatcher = new TestTeller();

  private final IReport reporterUnderTest = new DefaultReporterImpl();

  @Given("a running test case")
  public void a_running_test_case() {

  }

  @When("all its executions succeed")
  public void all_its_executions_succeed() {

  }

  @Then("the test case execution is over")
  public void the_test_case_execution_is_over() {

  }

  @And("the test case execution succeed")
  public void theTestCaseExecutionSucceed() {
  }


  private class TestTeller implements ITell {

    @Override
    public List<ExecutionEvent> events() {
      return null;
    }

  }

}
