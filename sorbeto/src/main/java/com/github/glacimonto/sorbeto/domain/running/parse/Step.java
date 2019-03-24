package com.github.glacimonto.sorbeto.domain.running.parse;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Step {

  private final String sentence;
  private final List<Step> subSteps;

  private Step(String sentence, List<Step> subSteps) {
    this.sentence = sentence;
    this.subSteps = subSteps;
  }

  @Override
  public String toString() {
    return "Step{" +
      "sentence='" + sentence + '\'' +
      ", subSteps=" + subSteps +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Step step = (Step) o;
    return sentence.equals(step.sentence) &&
      subSteps.equals(step.subSteps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sentence, subSteps);
  }

  public static StepBuilder builder() {
    return new StepBuilder();
  }

  public static class StepBuilder {
    private String sentence;
    private List<Step> subSteps = new LinkedList<>();

    private StepBuilder() {}

    public Step build() {
      if (subSteps.isEmpty()) {
        subSteps = emptyList();
      }
      return new Step(sentence, unmodifiableList(subSteps));
    }

    public StepBuilder sentence(String sentence) {
      this.sentence = sentence;
      return this;
    }

    public StepBuilder withSubStep(Step subStep) {
      subSteps.add(subStep);
      return this;
    }

    public StepBuilder withSubSteps(Step... subSteps) {
      Arrays.asList(subSteps).forEach(this::withSubStep);
      return this;
    }
  }
}