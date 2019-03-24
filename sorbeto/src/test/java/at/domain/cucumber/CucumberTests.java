package at.domain.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  strict   = true,
  plugin   = { "pretty", "json:target/cucumber-report.json" },
  features = { "classpath:at/domain/cucumber" },
  glue     = { "at.domain.cucumber.stepdefs" },
  tags     = { "@Witness", "not @Ignore" })

public class CucumberTests {

}
