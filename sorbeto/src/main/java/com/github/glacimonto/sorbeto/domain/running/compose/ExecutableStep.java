package com.github.glacimonto.sorbeto.domain.running.compose;

import java.util.Objects;

public class ExecutableStep implements PlannedStep {

  private final StepId stepId;
  private final String action; // TODO - Type me later

  private ExecutableStep(StepId stepId, String action) {
    this.stepId = stepId;
    this.action = action;
  }

  @Override
  public StepId stepId() {
    return stepId;
  }

  @Override
  public String toString() {
    return "ExecutableStep{" +
      "stepId=" + stepId +
      ", action='" + action + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExecutableStep that = (ExecutableStep) o;
    return stepId.equals(that.stepId) &&
      action.equals(that.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stepId, action);
  }

  public static ExecutableStepBuilder builder() {
    return new ExecutableStepBuilder();
  }

  public static class ExecutableStepBuilder {
    private StepId stepId;
    private String action;

    private ExecutableStepBuilder() {}

    public ExecutableStep build() {
      return new ExecutableStep(stepId, action);
    }

    public ExecutableStepBuilder withAction(String action) {
      this.action = action;
      return this;
    }

    public ExecutableStepBuilder withId(StepId stepId) {
      this.stepId = stepId;
      return this;
    }
  }

}
