package com.github.glacimonto.sorbeto.domain.running.parse;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Example {

  private final String feature;
  private final String scenario;
  private final List<Step> steps;

  private Example(String feature, String scenario, List<Step> steps) {
    this.feature = feature;
    this.scenario = scenario;
    this.steps = steps;
  }

  @Override
  public String toString() {
    return "Example{" +
      "feature='" + feature + '\'' +
      ", scenario='" + scenario + '\'' +
      ", steps=" + steps +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Example example = (Example) o;
    return feature.equals(example.feature) &&
      scenario.equals(example.scenario) &&
      steps.equals(example.steps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feature, scenario, steps);
  }

  public static ExampleBuilder builder() {
    return new ExampleBuilder();
  }

  public static class ExampleBuilder {
    private String feature;
    private String scenario;
    private List<Step> steps = new LinkedList<>();

    private ExampleBuilder() {}

    public Example build() {
      if (steps.isEmpty()) {
        steps = emptyList();
      }
      return new Example(feature, scenario, unmodifiableList(steps));
    }

    public ExampleBuilder forFeature(String feature) {
      this.feature = feature;
      return this;
    }

    public ExampleBuilder forScenario(String scenario) {
      this.scenario = scenario;
      return this;
    }

    public ExampleBuilder withStep(Step step) {
      steps.add(step);
      return this;
    }

    public ExampleBuilder withSteps(Step... step) {
      Arrays.asList(step).forEach(this::withStep);
      return this;
    }
  }

}