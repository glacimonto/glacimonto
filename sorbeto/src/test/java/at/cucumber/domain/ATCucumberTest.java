package at.cucumber.domain;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  strict   = true,
  plugin   = { "pretty", "json:target/cucumber-report.json" },
  features = { "classpath:at/cucumber/domain" },
  glue     = { "at.cucumber.domain.stepdefs" },
  tags     = { "not @Ignore" })
public class ATCucumberTest {

}
