package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.schedule.DefaultSchedulerImpl;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionStatus;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.schedule.Scheduler;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

public class SchedulingExecutionStepDefs {

  private ExecutionPlan givenExecutionPlan;
  private Scheduler scheduler = new DefaultSchedulerImpl();
  private List<ScheduledExecution> scheduledExecutions;

  @Given("the following execution plan")
  public void the_following_execution_plan(ExecutionPlan executionPlan) {
    givenExecutionPlan = executionPlan;
  }

  @And("there is no scheduled execution")
  public void there_is_no_scheduled_execution() {
    scheduledExecutions = scheduler.scheduled();
    assertThat(scheduledExecutions).isEmpty();
  }

  @When("it is scheduled")
  public void it_is_scheduled() {
    scheduler.schedule(givenExecutionPlan);
  }

  @Then("it schedules an execution")
  public void it_schedules_an_execution() {
    scheduledExecutions = scheduler.scheduled();
    assertThat(scheduledExecutions.size()).isEqualTo(1);
  }

  @And("its status is pending")
  public void its_status_is_pending() {
    ExecutionStatus actualStatus = scheduledExecutions.get(0).status();
    assertThat(actualStatus).isEqualTo(ExecutionStatus.PENDING);
  }


}
