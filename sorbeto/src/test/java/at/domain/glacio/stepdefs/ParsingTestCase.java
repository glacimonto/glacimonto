package at.domain.glacio.stepdefs;

import at.domain.testutils.TestContext;
import com.github.fridujo.glacio.running.api.Then;
import com.github.fridujo.glacio.running.api.When;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import com.github.glacimonto.sorbeto.domain.running.parse.IParse;
import com.github.glacimonto.sorbeto.domain.running.parse.ParserImpl;
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
