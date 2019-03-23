package com.github.glacimonto.sorbeto.domain.running.witness;

import com.github.glacimonto.sorbeto.domain.reporting.IRecord;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import java.util.List;

public class DefaultWitnessImpl implements IWitness {

  private final List<IRecord> recorders;

  public DefaultWitnessImpl(List<IRecord> recorders) {
    this.recorders = recorders;
  }

  @Override
  public List<ExecutionEvent> events() {
    return null;
  }

  @Override
  public void watch(ExecutionEvent executionEvent) {

  }

}