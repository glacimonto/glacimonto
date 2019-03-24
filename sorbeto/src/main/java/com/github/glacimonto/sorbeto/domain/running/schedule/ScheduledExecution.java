package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;

public interface ScheduledExecution {

  ExecutionRequestId requestId();

  ExecutionId id();

  ExecutionStatus status();

  ExecutionPlan plan();

}
