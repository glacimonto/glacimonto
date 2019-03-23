package at.domain.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.glacimonto.sorbeto.domain.running.compose.ICompose;
import com.github.glacimonto.sorbeto.domain.running.compose.DefaultComposerImpl;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComposingExample {

  private Example givenExample;
  private ICompose composer = new DefaultComposerImpl();
  private ExecutionPlan actualExecutionPlan;

  @Given("the following example")
  public void the_following_example(Example example) {
    givenExample = example;
  }

  @When("it is composed")
  public void it_is_composed() {
    actualExecutionPlan = composer.compose(givenExample);
  }

  @Then("it produces an execution plan")
  public void it_produces_an_execution_plan() {
    ExecutionPlan expectedExecutionPlan = new ExecutionPlan();
    assertThat(actualExecutionPlan).isEqualTo(expectedExecutionPlan);
  }

}
