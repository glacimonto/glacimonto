# language: en

@Scheduler
Feature: For scheduling an execution plan

   Scenario: Successfully schedule an execution plan into a pending execution
    Given the following execution plan
    And there is no scheduled execution
    When it is scheduled
    Then it schedules an execution
    And its status is pending
