# language: en

@Watcher
Feature: For watching an execution

  Scenario: Successfully watch an execution
    Given a running execution
    When all its steps succeed
    Then the execution is over
    And the execution succeed

