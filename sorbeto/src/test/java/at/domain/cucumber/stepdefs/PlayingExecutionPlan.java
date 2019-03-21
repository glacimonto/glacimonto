package at.domain.cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlayingExecutionPlan {

  @Given("a pending execution")
  public void a_pending_execution() {
//    throw new cucumber.api.PendingException();
  }

  @When("it is played")
  public void it_is_played() {
//    throw new cucumber.api.PendingException();
  }


  @Then("it produces a playing execution event")
  public void it_produces_a_playing_execution_event() {
//    throw new cucumber.api.PendingException();
  }

  @And("it produces X step execution event")
  public void it_produces_X_step_execution_event() {
//    throw new cucumber.api.PendingException();
  }

  @And("each step execution event is a success")
  public void each_step_execution_event_is_a_success() {
//    throw new cucumber.api.PendingException();
  }

}
