package com.github.glacimonto.sorbeto.domain.running.compose;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComposedStep implements PlannedStep {

  public final StepId stepId;
  public final String sentence;
  public final List<PlannedStep> steps;

  private ComposedStep(StepId stepId, String sentence, List<PlannedStep> steps) {
    this.stepId = stepId;
    this.sentence = sentence;
    this.steps = steps;
  }

  @Override
  public StepId stepId() {
    return stepId;
  }

  @Override
  public String toString() {
    return "ComposedStep{" +
      "stepId=" + stepId +
      ", sentence='" + sentence + '\'' +
      ", steps=" + steps +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ComposedStep that = (ComposedStep) o;
    return stepId.equals(that.stepId) &&
      sentence.equals(that.sentence) &&
      steps.equals(that.steps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stepId, sentence, steps);
  }

  public static ComposedStepBuilder builder() {
    return new ComposedStepBuilder();
  }

  public static class ComposedStepBuilder {
    private StepId stepId = new StepId(-1L); // TODO - NULL ME later
    private String sentence = "";
    private List<PlannedStep> steps = new ArrayList<>();

    private ComposedStepBuilder() {}

    public ComposedStep build() {
      if (steps.isEmpty()) {
        steps = emptyList();
      }
      return new ComposedStep(stepId, sentence, unmodifiableList(steps));
    }

    public ComposedStepBuilder sentence(String sentence) {
      this.sentence = sentence;
      return this;
    }

    public ComposedStepBuilder withSubStep(PlannedStep subStep) {
      steps.add(subStep);
      return this;
    }

    public ComposedStepBuilder withId(StepId stepId) {
      this.stepId = stepId;
      return this;
    }
  }

}
