package com.github.glacimonto.sorbeto.domain.running;

import com.github.glacimonto.sorbeto.domain.running.compose.ExecutionPlan;
import com.github.glacimonto.sorbeto.domain.running.compose.ICompose;
import com.github.glacimonto.sorbeto.domain.running.parse.Example;
import com.github.glacimonto.sorbeto.domain.running.parse.IParse;
import com.github.glacimonto.sorbeto.domain.running.schedule.ISchedule;

public class DefaultRunnerImpl implements IRun {

  private final IParse parser;
  private final ICompose composer;
  private final ISchedule scheduler;

  public DefaultRunnerImpl(IParse parser, ICompose composer, ISchedule scheduler) {
    this.parser = parser;
    this.composer = composer;
    this.scheduler = scheduler;
  }

  @Override
  public ExecutionRequestId run(String testCase) {
    final ExecutionRequestId executionRequestId = generateExecutionId(testCase);
    Example example = parser.parse(executionRequestId, testCase);
    ExecutionPlan executionPlan = composer.compose(executionRequestId, example);
    scheduler.schedule(executionRequestId, executionPlan); // TODO - take a list of execution plan
    return executionRequestId;
  }

  private ExecutionRequestId generateExecutionId(String testCase) {
    return new ExecutionRequestId(4242L);
  }

}
