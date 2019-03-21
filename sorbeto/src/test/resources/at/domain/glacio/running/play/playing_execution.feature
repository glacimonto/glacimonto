# language: en

Feature: For playing an execution

  Scenario: Successfully play an execution
    Given a pending execution
    When it is played
    Then it produces an execution report