package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepExecutionEvent;
import java.util.function.Function;
import java.util.stream.Stream;

public interface PlannedStep {

  StepId stepId();

  Stream<StepExecutionEvent> play();

  Stream<StepExecutionEvent> play(Function<ExecutionEvent, ExecutionEvent> notify);
}
