package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.play.Player;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.watch.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.watch.IWatch;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.stream.Collectors;

public class PlayingExecutionPlan {

  private ScheduledExecution givenPendingExecution;
  private TestPlayerObserver playerObserver = new TestPlayerObserver();
  private IPlay player = new Player();
  private List<ExecutionEvent> actualEvents;

  @Given("a pending execution")
  public void a_pending_execution() {
    givenPendingExecution = new ScheduledExecution();
    playerObserver.watch(player);
  }

  @When("it is played")
  public void it_is_played() {
    player.play(givenPendingExecution);
  }

  @Then("it produces a playing execution event")
  public void it_produces_a_playing_execution_event() {
    actualEvents = playerObserver.report(givenPendingExecution.executionId());
    ExecutionEvent expectedStartEvent = new PlayingEvent();
    assertThat(actualEvents).containsOnlyOnce(expectedStartEvent);
  }

  @And("it produces X step execution event")
  public void it_produces_X_step_execution_event() {
    assertThat(actualEvents.size()).isEqualTo(42);
  }

  @And("each step execution event is a success")
  public void each_step_execution_event_is_a_success() {
    assertThat(stepExecutionEvents()).allMatch(e -> e instanceof StepSucceedEvent);
  }

  private List<ExecutionEvent> stepExecutionEvents() {
    return actualEvents.stream()
      .filter(e -> !(e instanceof StepExecutionEvent))
      .collect(Collectors.toList());
  }

  private class TestPlayerObserver implements IWatch {

    @Override
    public void watch(IPlay player) {
      player.subscribe(this);
    }

    List<ExecutionEvent> report(ExecutionId id) {
      return null;
    }

  }

  private class PlayingEvent implements ExecutionEvent {
  }

  private interface StepExecutionEvent extends ExecutionEvent {
  }

  private class StepSucceedEvent implements StepExecutionEvent {
  }
}
