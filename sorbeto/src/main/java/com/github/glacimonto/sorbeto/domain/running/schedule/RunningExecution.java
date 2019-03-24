package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;

public class RunningExecution implements ScheduledExecution {

  private final ExecutionId executionId;
  private final ExecutionPlan executionPlan;
  private final ExecutionRequestId executionRequestId;

  public RunningExecution(ExecutionRequestId executionRequestId, ExecutionId executionId, ExecutionPlan executionPlan) {
    this.executionRequestId = executionRequestId;
    this.executionId = executionId;
    this.executionPlan = executionPlan;
  }

  @Override
  public ExecutionRequestId requestId() {
    return executionRequestId;
  }

  @Override
  public ExecutionId id() {
    return this.executionId;
  }

  @Override
  public ExecutionStatus status() {
    return ExecutionStatus.RUNNING;
  }

  @Override
  public ExecutionPlan plan() {
    return this.executionPlan;
  }

}