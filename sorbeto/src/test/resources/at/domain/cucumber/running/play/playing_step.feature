# language: en

Feature: For playing a step

  Scenario: Successfully play a step
    Given a step
    When the step is played
    Then it produces a step execution report

