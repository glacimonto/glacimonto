package at.domain.cucumber.stepdefs.running;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.DefaultComposerImpl;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.compose.ICompose;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComposingExample {

  private Example givenExample;
  private ICompose composerUnderTest = new DefaultComposerImpl();
  private ExecutionPlan actualExecutionPlan;
  private ExecutionRequestId executionRequestId = new ExecutionRequestId(42L);

  @Given("an example")
  public void an_example_example() {
    givenExample = new Example(executionRequestId);
  }

  @When("it is composed")
  public void it_is_composed() {
    actualExecutionPlan = composerUnderTest.compose(executionRequestId, givenExample);
  }

  @Then("it produces an execution plan")
  public void it_produces_an_execution_plan() {
    ExecutionPlan expectedExecutionPlan = new ExecutionPlan(executionRequestId);
    assertThat(actualExecutionPlan).isEqualTo(expectedExecutionPlan);
  }

}