# language: en

@Player
Feature: For playing an execution

  Scenario: Successfully play an execution
    Given a pending execution
    When it is played
    Then it produces a playing execution event
    And it produces X step execution event
    And each step execution event is a success