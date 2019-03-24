package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;

public interface ScheduledExecution {

  ExecutionId id();

  ExecutionStatus status();

  ExecutionPlan plan();

}
