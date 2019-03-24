package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;
import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import java.util.List;

public interface ISchedule {

  List<ScheduledExecution> scheduled();

  void schedule(ExecutionRequestId executionRequestId, ExecutionPlan givenExecutionPlan);
}