# language: en

@Parser
Feature: For parsing a test case

  A Test Case illustrates a specific case that could possibly occur during application runtime,
  and for which it defines the expected behavior.

  A Test Case has, at least: [a purpose, a description, a scenario, a data set]

  Scenario: Successfully parse a test case without data set
    Given the following glacio test case
    """
    Feature: Fake Glacio test case
      Fake description

      Scenario: Fake scenario
        When a success action is executed
          Do success
        Then the execution succeed
          Do success
    """
    When it is parsed
    Then it produces an example
