package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import java.util.ArrayList;
import java.util.List;

public class DefaultSchedulerImpl implements ISchedule {

  private final List<ScheduledExecution> sheduledExecutions = new ArrayList<>();

  @Override
  public List<ScheduledExecution> scheduled() {
    return sheduledExecutions;
  }

  @Override
  public void schedule(ExecutionPlan executionPlan) {
    final ScheduledExecution pendingExecution = new PendingExecution(executionId(), executionPlan);
    sheduledExecutions.add(pendingExecution);
  }

  private ExecutionId executionId() {
    return new ExecutionId(42L);
  }


}