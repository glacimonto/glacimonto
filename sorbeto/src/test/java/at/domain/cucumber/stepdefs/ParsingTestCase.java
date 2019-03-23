package at.domain.cucumber.stepdefs;

import at.domain.testutils.TestContext;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import com.github.glacimonto.sorbeto.domain.running.parse.IParse;
import com.github.glacimonto.sorbeto.domain.running.parse.ParserImpl;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class ParsingTestCase {

  private Example example;
  private IParse parser = new ParserImpl();

  @When("it is parsed")
  public void it_is_parsed() {
    example = parser.parse(TestContext.TEST_CASE);
  }

  @Then("it produces an example")
  public void it_produces_an_example() {
    Example expectedExample = new Example();
    Assertions.assertThat(example).isEqualTo(expectedExample);
  }

}