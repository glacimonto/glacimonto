package at.domain.glacio.stepdefs;

import at.domain.testutils.TestContext;
import com.github.fridujo.glacio.running.api.Then;
import com.github.fridujo.glacio.running.api.When;
import org.assertj.core.api.Assertions;

public class TestCaseParsingStepDef {

  private Example example;
  private Parser parser = new ParserImpl();

  @When("it is parsed")
  public void it_is_parsed() {
    example = parser.parse(TestContext.TEST_CASE);
  }

  @Then("it produces an example")
  public void it_produces_an_example() {
    Example expectedExample = new Example();
    Assertions.assertThat(example).isEqualTo(expectedExample);
  }

  private class Example {
  }

  private interface Parser {
    Example parse(String testCase);
  }

  private class ParserImpl implements Parser {
    @Override
    public Example parse(String testCase) {
      return null;
    }
  }
}
