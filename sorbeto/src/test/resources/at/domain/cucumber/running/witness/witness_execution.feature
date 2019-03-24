# language: en

@Witness
Feature: For witnessing an execution

  Scenario: Successfully witness an execution
    Given a running execution
    When all its steps succeed
    Then the execution is over
    And it tells a successful execution

