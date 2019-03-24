package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.play.DefaultPlayerImpl;
import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import com.github.glacimonto.sorbeto.domain.running.schedule.PendingExecution;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.witness.ITell;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.PlayingEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepSucceedEvent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Collections;
import java.util.List;

public class PlayingExecution {

  private ScheduledExecution givenPendingExecution;
  private ITell fakeTeller = new FakeTeller();
  private IPlay playerUnderTest = new DefaultPlayerImpl(fakeTeller);

  @Given("a pending execution")
  public void a_pending_execution() {
    givenPendingExecution = new PendingExecution(new ExecutionId(42L), new ExecutionPlan(new ExecutionRequestId(0L)));
  }

  @When("it is played")
  public void it_is_played() {
    playerUnderTest.play(givenPendingExecution);
  }

  @Then("it produces a playing execution event")
  public void it_produces_a_playing_execution_event() {
    ExecutionEvent expectedPlayingEvent = new PlayingEvent(){};
    assertThat(fakeTeller.first()).isEqualTo(expectedPlayingEvent);
  }

  @And("it produces X step execution event")
  public void it_produces_X_step_execution_event() {
    assertThat(fakeTeller.count()).isEqualTo(42);
  }

  @And("each step execution event is a success")
  public void each_step_execution_event_is_a_success() {
    assertThat(fakeTeller.steps()).allMatch(e -> e instanceof StepSucceedEvent);
  }

  private class FakeTeller implements ITell {

    @Override
    public List<ExecutionEvent> events() {
      return Collections.emptyList();
    }

  }

}
