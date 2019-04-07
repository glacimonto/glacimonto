package com.github.glacimonto.sorbeto.domain.running.compose;

import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import java.util.function.Function;

public interface PlannedStep {

  StepId stepId();

  void play(Function<ExecutionEvent, ExecutionEvent> notify);
}
