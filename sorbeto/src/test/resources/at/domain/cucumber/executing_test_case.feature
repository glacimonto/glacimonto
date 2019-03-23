# language: en

@Sorbeto
@Runner
Feature: For executing a test case

  A Test Case illustrates a specific case that could possibly occur during application runtime,
  and for which it defines the expected behavior.

  A Test Case has, at least: [a purpose, a description, a scenario, a data set]

  Executing a test case implies the following process :
    - Parsing the test case from its source format
    - Splitting the test case into one or many examples
    - Composing an execution plan for each example
    - Scheduling each execution plan
    - Playing each execution plan
      - Player orchestrates the execution according to the plan
      - Player delegates effective execution to the appropriate Action
    - Listening and Reporting run results

  Scenario: Successfully execute a test case without data set
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
    When it is executed
    Then the execution succeed
