package com.github.glacimonto.sorbeto.domain.running.compose;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepExecutionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComposedStep implements PlannedStep {

  public final StepId stepId;
  public final String sentence;
  public final List<PlannedStep> steps;
  public final String property;

  private ComposedStep(StepId stepId, String sentence, List<PlannedStep> steps, String property) {
    this.stepId = stepId;
    this.sentence = sentence;
    this.steps = steps;
    this.property = property;
  }

  @Override
  public StepId stepId() {
    return stepId;
  }

  @Override
  public void play(Function<ExecutionEvent, ExecutionEvent> notify) {
    steps.stream()
      .peek(s -> s.play(notify))
      .collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return "ComposedStep{" +
      "stepId=" + stepId +
      ", sentence='" + sentence + '\'' +
      ", steps=" + steps +
      ", property='" + property + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ComposedStep that = (ComposedStep) o;
    return stepId.equals(that.stepId) &&
      sentence.equals(that.sentence) &&
      steps.equals(that.steps) &&
      property.equals(that.property);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stepId, sentence, steps, property);
  }

  public static ComposedStepBuilder builder() {
    return new ComposedStepBuilder();
  }

  public static class ComposedStepBuilder {
    private StepId stepId = new StepId(-1L); // TODO - NULL ME later
    private String sentence = ""; // TODO - NULL ME later
    private List<PlannedStep> steps = new ArrayList<>();
    private String property = "";

    private ComposedStepBuilder() {}

    public ComposedStep build() {
      if (steps.isEmpty()) {
        steps = emptyList();
      }
      return new ComposedStep(stepId, sentence, unmodifiableList(steps), property);
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

    public ComposedStepBuilder withProperty(String property) {
      this.property = property;
      return this;
    }
  }

}
