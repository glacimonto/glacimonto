package com.github.glacimonto.sorbeto.domain.running.schedule;

import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import java.util.List;

public interface Scheduler {

  List<ScheduledExecution> scheduled();

  void schedule(ExecutionPlan givenExecutionPlan);
}