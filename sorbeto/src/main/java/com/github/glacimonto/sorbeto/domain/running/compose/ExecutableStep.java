package com.github.glacimonto.sorbeto.domain.running.compose;

import java.util.Objects;

public class ExecutableStep implements PlannedStep {

  public final StepId stepId;
  public final String action; // TODO - Type me later
  public final String property;

  private ExecutableStep(StepId stepId, String action, String property) {
    this.stepId = stepId;
    this.action = action;
    this.property = property;
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
      ", property='" + property + '\'' +
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
    private String action = "";
    private String property = "";

    private ExecutableStepBuilder() {}

    public ExecutableStep build() {
      return new ExecutableStep(stepId, action, property);
    }

    public ExecutableStepBuilder withAction(String action) {
      this.action = action;
      return this;
    }

    public ExecutableStepBuilder withId(StepId stepId) {
      this.stepId = stepId;
      return this;
    }

    public ExecutableStepBuilder withProperty(String property) {
      this.property = property;
      return this;
    }
  }

}
