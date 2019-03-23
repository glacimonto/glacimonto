package com.github.glacimonto.sorbeto.domain.running.witness;

import com.github.glacimonto.sorbeto.domain.reporting.IReport;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import java.util.List;

public class DefaultWitnessImpl implements IWitness {

  private final List<IReport> reporters;

  public DefaultWitnessImpl(List<IReport> reporters) {
    this.reporters = reporters;
  }

  @Override
  public List<ExecutionEvent> events() {
    return null;
  }

  @Override
  public void watch(ExecutionEvent executionEvent) {

  }

}