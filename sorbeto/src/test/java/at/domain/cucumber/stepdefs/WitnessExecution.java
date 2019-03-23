package at.domain.cucumber.stepdefs;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.reporting.IReport;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;
import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.witness.DefaultWitnessImpl;
import com.github.glacimonto.sorbeto.domain.running.witness.IWatch;
import com.github.glacimonto.sorbeto.domain.running.witness.IWitness;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.PlayingEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepSucceedEvent;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Collections;

public class WitnessExecution {

  private ScheduledExecution givenRunningExecution;
  private final FakeReporter fakeReporter = new FakeReporter();

  private IWitness witnessUnderTest = new DefaultWitnessImpl(Collections.singletonList(fakeReporter));
  private final IPlay fakePlayer = new FakePlayer(witnessUnderTest);

  @Given("a running execution")
  public void a_running_execution() {
    givenRunningExecution = new ScheduledExecution();
  }

  @When("all its steps succeed")
  public void all_its_steps_succeed() {
    fakePlayer.play(givenRunningExecution);
  }

  @Then("the execution is over")
  public void the_execution_is_over() {
  }

  private class FakePlayer implements IPlay {

    private final IWatch witness;

    FakePlayer(IWatch witness) {
      this.witness = witness;
    }

    @Override
    public void play(ScheduledExecution givenPendingExecution) {
      witness.watch((new PlayingEvent(){}));
      for (int i = 0; i < 4; i++) { witness.watch(new StepSucceedEvent() {}); }
      witness.watch((new EndEvent(){}));
    }

  }

  private class FakeReporter implements IReport {

    @Override
    public TestCaseExecutionReport follow(ExecutionRequestId executionRequestId) {
      return null;
    }

  }

  private class EndEvent implements ExecutionEvent {
  }
}
