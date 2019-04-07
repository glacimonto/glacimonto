package com.github.glacimonto.sorbeto.domain.running.witness;

import com.github.glacimonto.sorbeto.domain.reporting.IRecord;
import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import java.util.ArrayList;
import java.util.List;

public class DefaultWitnessImpl implements IWitness {

  private final List<ExecutionEvent> events = new ArrayList<>();
  private final List<IRecord> reporters = new ArrayList<>();

  private final ExecutionRequestId executionRequestId;
  private final ExecutionId executionId;
  private final ExecutionPlan executionPlan;

  public DefaultWitnessImpl(ExecutionRequestId executionRequestId, ExecutionId executionId, ExecutionPlan executionPlan) {
    this.executionRequestId = executionRequestId;
    this.executionId = executionId;
    this.executionPlan = executionPlan;
  }

  @Override
  public List<ExecutionEvent> events() {
    return events;
  }

  @Override
  public ExecutionReport report() {
    return new ExecutionReport(executionRequestId, executionId);
  }

  @Override
  public void register(List<IRecord> reporters) {
    this.reporters.addAll(reporters);
  }

  @Override
  public void watch(ExecutionEvent executionEvent) {
    events.add(executionEvent);
    System.out.println(executionEvent.type());
    tell();
  }

  private void tell() {
    reporters.forEach(r -> r.record(report()));
  }

}