package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;

public class PendingExecution implements ScheduledExecution {

  private final ExecutionRequestId executionRequestId;
  private final ExecutionId id;
  private final ExecutionPlan executionPlan;

  public PendingExecution(ExecutionRequestId executionRequestId, ExecutionId id, ExecutionPlan executionPlan) {
    this.executionRequestId = executionRequestId;
    this.id = id;
    this.executionPlan = executionPlan;
  }

  @Override
  public ExecutionRequestId requestId() {
    return executionRequestId;
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