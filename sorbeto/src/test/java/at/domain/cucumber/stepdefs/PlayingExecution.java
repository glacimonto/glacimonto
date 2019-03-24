package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.play.DefaultPlayerImpl;
import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import com.github.glacimonto.sorbeto.domain.running.schedule.PendingExecution;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.witness.IWitness;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.PlayingEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepSucceedEvent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;

// TODO - Model ExecutionPlan domain entity
// TODO - Model each ExecutionEvent domain events
public class PlayingExecution {

  private ScheduledExecution givenPendingExecution;
  private IWitness fakeWitness = new FakeWitness();
  private IPlay playerUnderTest = new DefaultPlayerImpl(fakeWitness);
  private ExecutionId executionId = new ExecutionId(42L);

  @Given("a pending execution")
  public void a_pending_execution() {
    givenPendingExecution = new PendingExecution(executionId, new ExecutionPlan(new ExecutionRequestId(0L)));
  }

  @When("it is played")
  public void it_is_played() {
    playerUnderTest.play(givenPendingExecution);
  }

  @Then("it produces a playing execution event")
  public void it_produces_a_playing_execution_event() {
    ExecutionEvent expectedPlayingEvent = new PlayingEvent(executionId);
    assertThat(fakeWitness.first()).isEqualTo(expectedPlayingEvent);
    assertThat(fakeWitness.first().type()).isEqualTo("PLAYING_EVENT");
  }

  @And("it produces X events")
  public void it_produces_X_events() {
    assertThat(fakeWitness.count()).isEqualTo(2);
  }

  @And("each step execution event is a success")
  public void each_step_execution_event_is_a_success() {
    assertThat(fakeWitness.steps()).isNotEmpty().allMatch(e -> e instanceof StepSucceedEvent);
  }

  private class FakeWitness implements IWitness {

    private final List<ExecutionEvent> events = new ArrayList<>();

    @Override
    public List<ExecutionEvent> events() {
      return events;
    }

    @Override
    public void watch(ExecutionEvent executionEvent) {
      events.add(executionEvent);
    }

  }

}
