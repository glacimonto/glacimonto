package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.reporting.IRecord;
import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.play.DefaultPlayerImpl;
import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.witness.DefaultWitnessImpl;
import com.github.glacimonto.sorbeto.domain.running.witness.IWitness;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultSchedulerImpl implements ISchedule {

  private final List<ScheduledExecution> scheduledExecutions = new ArrayList<>();
  private final IRecord reporter;

  public DefaultSchedulerImpl(IRecord reporter) {
    this.reporter = reporter;
  }

  @Override
  public List<ScheduledExecution> scheduled() {
    return scheduledExecutions;
  }

  @Override
  public void schedule(ExecutionRequestId executionRequestId, ExecutionPlan executionPlan) {
    final ScheduledExecution pendingExecution = new PendingExecution(executionRequestId, executionId(), executionPlan);
    append(pendingExecution);
  }

  private ExecutionId executionId() {
    return new ExecutionId(42L);
  }

  private void append(ScheduledExecution pendingExecution) {
    scheduledExecutions.add(pendingExecution);
    trigger(pendingExecution);
  }

  private void trigger(ScheduledExecution pendingExecution) {
    IWitness watcher = new DefaultWitnessImpl(pendingExecution.requestId(), executionId(), pendingExecution.plan());
    watcher.register(Collections.singletonList(reporter));
    IPlay player = new DefaultPlayerImpl(watcher);
    player.play(pendingExecution);
  }

}