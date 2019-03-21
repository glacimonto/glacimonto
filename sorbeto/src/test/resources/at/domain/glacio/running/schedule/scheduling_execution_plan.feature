# language: en

Feature: For scheduling an execution plan

   Scenario: Successfully schedule an execution plan into a pending execution
    Given the following execution plan
    And there is not any pending execution
    When it is scheduled
    Then an execution is pending
