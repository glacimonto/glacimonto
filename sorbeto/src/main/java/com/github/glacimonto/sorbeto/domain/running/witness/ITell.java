package com.github.glacimonto.sorbeto.domain.running.witness;

import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.NullEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepExecutionEvent;
import java.util.List;
import java.util.stream.Collectors;

public interface ITell {

  int MAX_NUMBER_OF_EVENTS = 10000;

  List<ExecutionEvent> events();

  default ExecutionEvent first() {
   return events().stream()
     .findFirst()
     .orElse(new NullEvent(new ExecutionId(-1L)));
  }

  default ExecutionEvent last() {
    return events().stream()
      .limit(MAX_NUMBER_OF_EVENTS)
      .reduce((first, second) -> second)
      .orElse(new NullEvent(new ExecutionId(-1L)));
  }

  default int count() {
    return events().size();
  }

  default List<ExecutionEvent> steps() {
    return events().stream()
      .filter(e -> e instanceof StepExecutionEvent)
      .collect(Collectors.toList());
  }

}
