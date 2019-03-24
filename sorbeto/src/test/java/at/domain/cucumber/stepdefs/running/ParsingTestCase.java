package at.domain.cucumber.stepdefs.running;

import at.domain.testutils.TestContext;
import com.github.glacimonto.sorbeto.domain.running.parse.DefaultParserImpl;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import com.github.glacimonto.sorbeto.domain.running.parse.IParse;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class ParsingTestCase {

  private Example actualExample;
  private IParse parserUnderTest = new DefaultParserImpl();

  @When("it is parsed")
  public void it_is_parsed() {
    actualExample = parserUnderTest.parse(TestContext.TEST_CASE);
  }

  @Then("it produces an example")
  public void it_produces_an_example() {
    Example expectedExample = TestContext.SIMPLE_EXAMPLE;
    Assertions.assertThat(actualExample).isEqualTo(expectedExample);
  }

}
