package com.github.glacimonto.sorbeto.domain.running.witness;

import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import java.util.ArrayList;
import java.util.List;

public class DefaultWitnessImpl implements IWitness {

  private final List<ExecutionEvent> events = new ArrayList<>();

  public DefaultWitnessImpl() {
  }

  @Override
  public List<ExecutionEvent> events() {
    return events;
  }

  @Override
  public ExecutionReport report() {
    return new ExecutionReport();
  }

  @Override
  public void watch(ExecutionEvent executionEvent) {
    events.add(executionEvent);
  }

}