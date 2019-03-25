package com.github.glacimonto.sorbeto.domain.running.witness;

import static com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId.NO_EXECUTION;

import com.github.glacimonto.sorbeto.domain.reporting.IRecord;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.NoEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepFailedEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepSucceedEvent;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface ITell {

  int MAX_NUMBER_OF_EVENTS = 10000;

  List<ExecutionEvent> events();

  default ExecutionEvent first() {
   return events().stream()
     .findFirst()
     .orElse(new NoEvent(NO_EXECUTION));
  }

  default ExecutionEvent last() {
    return events().stream()
      .limit(MAX_NUMBER_OF_EVENTS)
      .reduce((first, second) -> second)
      .orElse(new NoEvent(NO_EXECUTION));
  }

  default int count() {
    return events().size();
  }

  default List<ExecutionEvent> steps() {
    return steps(e -> e instanceof StepExecutionEvent);
  }

  default List<ExecutionEvent> endedSteps() {
    return steps(e -> e instanceof StepSucceedEvent || e instanceof StepFailedEvent);
  }

  default List<ExecutionEvent> steps(Predicate<ExecutionEvent> predicate) {
    return events().stream()
      .filter(predicate)
      .collect(Collectors.toList());
  }

  ExecutionReport report();

  void register(List<IRecord> reporter);

}
