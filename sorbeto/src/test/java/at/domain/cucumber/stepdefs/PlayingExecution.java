package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.reporting.IReport;
import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.play.Player;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.watch.IWatch;
import com.github.glacimonto.sorbeto.domain.running.watch.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.watch.event.PlayingEvent;
import com.github.glacimonto.sorbeto.domain.running.watch.event.StepSucceedEvent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Collections;
import java.util.List;

public class PlayingExecution {

  private ScheduledExecution givenPendingExecution;
  private TestWatcher testWatcher = new TestWatcher();
  private IPlay playerUnderTest = new Player();

  @Given("a pending execution")
  public void a_pending_execution() {
    givenPendingExecution = new ScheduledExecution();
    testWatcher.watch(playerUnderTest);
  }

  @When("it is played")
  public void it_is_played() {
    playerUnderTest.play(givenPendingExecution);
  }

  @Then("it produces a playing execution event")
  public void it_produces_a_playing_execution_event() {
    ExecutionEvent expectedStartEvent = new PlayingEvent(){};
    assertThat(testWatcher.first()).isEqualTo(expectedStartEvent);
  }

  @And("it produces X step execution event")
  public void it_produces_X_step_execution_event() {
    assertThat(testWatcher.count()).isEqualTo(42);
  }

  @And("each step execution event is a success")
  public void each_step_execution_event_is_a_success() {
    assertThat(testWatcher.steps()).allMatch(e -> e instanceof StepSucceedEvent);
  }

  private class TestWatcher implements IWatch {

    @Override
    public void watch(IPlay player) {
      player.subscribe(this);
    }

    @Override
    public List<ExecutionEvent> events() {
      return Collections.emptyList();
    }

    @Override
    public void send(ExecutionEvent executionEvent) {

    }

    @Override
    public void subscribe(IReport reporter) {

    }

  }

}
