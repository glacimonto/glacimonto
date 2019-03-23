# language: en

@Composer
Feature: For composing an example

  Scenario: Successfully compose an example into an execution plan
    Given an example
    When it is composed
    Then it produces an execution plan

