# language: en

Feature: For playing a step

  Scenario: Successfully play a step
    Given a step
    When the step is played
    Then it produces a playing step event
    And it produces a step report event
    And the step report event is a success
