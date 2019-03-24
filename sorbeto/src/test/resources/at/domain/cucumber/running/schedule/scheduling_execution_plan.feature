# language: en

@Scheduler
Feature: For scheduling an execution plan

   Scenario: Successfully schedule an execution plan into a pending execution
    Given an execution plan
    And there is no scheduled execution
    When it is scheduled
    Then it schedules an execution
    And its status is pending
    And it has a unique identifier
    And it corresponds to the given execution plan
