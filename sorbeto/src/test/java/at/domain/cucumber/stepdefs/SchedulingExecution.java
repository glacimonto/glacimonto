package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.schedule.DefaultSchedulerImpl;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionStatus;
import com.github.glacimonto.sorbeto.domain.running.schedule.ISchedule;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

public class SchedulingExecution {

  private ExecutionPlan givenExecutionPlan;
  private ISchedule schedulerUnderTest = new DefaultSchedulerImpl();
  private List<ScheduledExecution> scheduledExecutions;

  @Given("an execution plan")
  public void an_execution_plan() {
    givenExecutionPlan = new ExecutionPlan(new ExecutionRequestId(0L));
  }

  @And("there is no scheduled execution")
  public void there_is_no_scheduled_execution() {
    scheduledExecutions = schedulerUnderTest.scheduled();
    assertThat(scheduledExecutions).isEmpty();
  }

  @When("it is scheduled")
  public void it_is_scheduled() {
    schedulerUnderTest.schedule(givenExecutionPlan);
  }

  @Then("it schedules an execution")
  public void it_schedules_an_execution() {
    scheduledExecutions = schedulerUnderTest.scheduled();
    assertThat(scheduledExecutions.size()).isEqualTo(1);
  }

  @And("its status is pending")
  public void its_status_is_pending() {
    ExecutionStatus actualStatus = scheduledExecutions.get(0).status();
    assertThat(actualStatus).isEqualTo(ExecutionStatus.PENDING);
  }

  @And("it has a unique identifier")
  public void it_has_a_unique_identifier() {
    ExecutionId actualExecutionId = scheduledExecutions.get(0).id();
    ExecutionId expectedExecutionId = new ExecutionId(42L);
    assertThat(actualExecutionId).isEqualTo(expectedExecutionId);
  }

  @And("it corresponds to the given execution plan")
  public void it_corresponds_to_the_given_execution_plan() {
    ExecutionPlan actualExecutionPlan = scheduledExecutions.get(0).plan();
    assertThat(actualExecutionPlan).isEqualTo(givenExecutionPlan);
  }

}
