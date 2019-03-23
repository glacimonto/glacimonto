# language: en

@Reporter
Feature: For reporting a test case execution

  Scenario: Successfully report a test case execution
    Given a running test case
    When all its executions succeed
    Then the test case execution is over
    And the test case execution succeed

