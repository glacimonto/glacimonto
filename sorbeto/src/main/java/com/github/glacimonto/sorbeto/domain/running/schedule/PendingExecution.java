package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;

public class PendingExecution implements ScheduledExecution {

  private final ExecutionId id;
  private final ExecutionPlan executionPlan;

  public PendingExecution(ExecutionId id, ExecutionPlan executionPlan) {
    this.id = id;
    this.executionPlan = executionPlan;
  }

  @Override
  public ExecutionId id() {
    return id;
  }

  @Override
  public ExecutionStatus status() {
    return ExecutionStatus.PENDING;
  }

  @Override
  public ExecutionPlan plan() {
    return executionPlan;
  }

}