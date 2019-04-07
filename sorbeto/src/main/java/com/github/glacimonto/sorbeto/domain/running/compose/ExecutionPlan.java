package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExecutionPlan {

  public final Example example;
  public final List<PlannedStep> plannedSteps;

  private ExecutionPlan(Example example, List<PlannedStep> plannedSteps) {
    this.example = example;
    this.plannedSteps = plannedSteps;
  }

  @Override
  public String toString() {
    return "ExecutionPlan{" +
      "example=" + example +
      ", plannedSteps=" + plannedSteps +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExecutionPlan that = (ExecutionPlan) o;
    return example.equals(that.example) &&
      plannedSteps.equals(that.plannedSteps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(example, plannedSteps);
  }

  public static ExecutionPlanBuilder builder() {
    return new ExecutionPlanBuilder();
  }

  public void play(Function<ExecutionEvent, ExecutionEvent> notify) {
    plannedSteps.stream()
      .peek( s -> s.play(notify) )
      .collect(Collectors.toList());
  }

  public static class ExecutionPlanBuilder {

    private Example example;
    private List<PlannedStep> plannedSteps = new ArrayList<>();

    private ExecutionPlanBuilder() {}

    public ExecutionPlan build() {
      return new ExecutionPlan(example, plannedSteps);
    }

    public ExecutionPlanBuilder forExample(Example example) {
      this.example = example;
      return this;
    }

    public ExecutionPlanBuilder planStep(PlannedStep plannedStep) {
      this.plannedSteps.add(plannedStep);
      return this;
    }
  }
}