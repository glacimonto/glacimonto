package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlayingStep {

  private Step givenStep;
  private IPlayStep stepPlayerUnderTest = new DefaultStepPlayer();
  private IPlay fakePlayer = new FakePlayer(stepPlayerUnderTest);

  @Given("a step")
  public void a_step() {
    givenStep = new Step();
  }

  @When("the step is played")
  public void the_step_is_played() {
    stepPlayerUnderTest.play(givenStep);
  }

  @Then("it produces a playing step event")
  public void it_produces_a_playing_step_event() {
    ExecutionEvent expectedPlayingEvent = new PlayingStepEvent(){};
  }

  @And("it produces a step report event")
  public void it_produces_a_step_report_event() {
//    throw new cucumber.api.PendingException();
  }

  @And("the step report event is a success")
  public void the_step_report_event_is_a_success() {
//    throw new cucumber.api.PendingException();

  }

  public class Step {

  }

  private class DefaultStepPlayer implements IPlayStep {
    @Override
    public void play(Step step) {

    }
  }

  private interface IPlayStep {
    void play(Step step);
  }

  private interface PlayingStepEvent extends ExecutionEvent {
  }

  private class FakePlayer implements IPlay {
    public FakePlayer(IPlayStep stepPlayerUnderTest) {

    }

    @Override
    public void play(ScheduledExecution givenPendingExecution) {

    }
  }
}
