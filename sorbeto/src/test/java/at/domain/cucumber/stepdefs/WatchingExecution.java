package at.domain.cucumber.stepdefs;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.reporting.IReport;
import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;
import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.watch.DefaultWatcherImpl;
import com.github.glacimonto.sorbeto.domain.running.watch.IWatch;
import com.github.glacimonto.sorbeto.domain.running.watch.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.watch.event.PlayingEvent;
import com.github.glacimonto.sorbeto.domain.running.watch.event.StepSucceedEvent;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class WatchingExecution {

  private ScheduledExecution givenRunningExecution;
  private final IPlay testPlayer = new TestPlayer();
  private final TestReporter testReporter = new TestReporter();

  private IWatch watcherUnderTest = new DefaultWatcherImpl();

  @Given("a running execution")
  public void a_running_execution() {
    givenRunningExecution = new ScheduledExecution();
    watcherUnderTest.watch(testPlayer);
    testReporter.observe(watcherUnderTest);
  }

  @When("all its steps succeed")
  public void all_its_steps_succeed() {
    testPlayer.play(givenRunningExecution);
  }

  @Then("the execution is over")
  public void the_execution_is_over() {
  }

  private class TestPlayer implements IPlay {

    private final List<IWatch> watchers = new ArrayList<>();

    @Override
    public void play(ScheduledExecution givenPendingExecution) {
      watchers.forEach(w-> w.send((new PlayingEvent(){})));

      for (int i = 0; i < 4; i++) {
        watchers.forEach(w -> w.send(new StepSucceedEvent() {}));
      }

      watchers.forEach(w-> w.send((new EndEvent(){})));
    }

    @Override
    public void subscribe(IWatch watcher) {
      watchers.add(watcher);
    }

  }

  private class TestReporter implements IReport {

    @Override
    public TestCaseExecutionReport follow(ExecutionRequestId executionRequestId) {
      return null;
    }

    public void observe(IWatch watcher) {
      watcher.subscribe(this);
    }
  }

  private class EndEvent implements ExecutionEvent {
  }
}
