package at.domain.cucumber.stepdefs.running;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import com.github.glacimonto.sorbeto.domain.running.schedule.RunningExecution;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.witness.DefaultWitnessImpl;
import com.github.glacimonto.sorbeto.domain.running.witness.ExecutionReport;
import com.github.glacimonto.sorbeto.domain.running.witness.IWatch;
import com.github.glacimonto.sorbeto.domain.running.witness.IWitness;
import com.github.glacimonto.sorbeto.domain.running.witness.event.EndedEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.PlayingEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepSucceedEvent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO - find a name for recording and reporting
// TODO - Model ExecutionReport domain entity
public class WitnessExecution {

  private ScheduledExecution givenRunningExecution;

  private ExecutionRequestId executionRequestId = new ExecutionRequestId(4242L);
  private ExecutionId executionId = new ExecutionId(42L);
  private IWitness witnessUnderTest = new DefaultWitnessImpl(executionRequestId, executionId, mock(ExecutionPlan.class));
  private final IPlay fakePlayer = new FakePlayer(witnessUnderTest);

  @Given("a running execution")
  public void a_running_execution() {
    givenRunningExecution = new RunningExecution(executionRequestId, executionId, new ExecutionPlan(new ExecutionRequestId(0L)));
  }

  @When("all its steps succeed")
  public void all_its_steps_succeed() {
    fakePlayer.play(givenRunningExecution);
  }

  @Then("the execution is over")
  public void the_execution_is_over() {
    assertThat(witnessUnderTest.last()).isEqualTo(new EndedEvent(executionId));
  }

  @And("it tells a successful execution")
  public void it_tells_a_successful_execution() {
    ExecutionReport expectedReport = new ExecutionReport(executionRequestId, executionId);
    assertThat(witnessUnderTest.report()).isEqualTo(expectedReport);
  }

  private class FakePlayer implements IPlay {

    private final IWatch witness;

    FakePlayer(IWatch witness) {
      this.witness = witness;
    }

    @Override
    public void play(ScheduledExecution executionExecution) {
      witness.watch((new PlayingEvent(executionExecution.id())));
      for (int i = 0; i < 4; i++) { witness.watch(new StepSucceedEvent(executionExecution.id())); }
      witness.watch((new EndedEvent(executionExecution.id())));
    }

  }

}
