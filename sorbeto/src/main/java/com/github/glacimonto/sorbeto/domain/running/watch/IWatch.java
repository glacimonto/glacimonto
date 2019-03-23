package com.github.glacimonto.sorbeto.domain.running.watch;

import com.github.glacimonto.sorbeto.domain.reporting.IReport;
import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.watch.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.watch.event.NullEvent;
import com.github.glacimonto.sorbeto.domain.running.watch.event.StepExecutionEvent;
import java.util.List;
import java.util.stream.Collectors;

public interface IWatch {

  int MAX_NUMBER_OF_EVENTS = 10000;

  void watch(IPlay player);

  List<ExecutionEvent> events();

  default ExecutionEvent first() {
   return events().stream()
     .findFirst()
     .orElse(new NullEvent(){});
  }

  default ExecutionEvent last() {
    return events().stream()
      .limit(MAX_NUMBER_OF_EVENTS)
      .reduce((first, second) -> second)
      .orElse(new NullEvent(){});
  }

  default int count() {
    return events().size();
  }

  default List<ExecutionEvent> steps() {
    return events().stream()
      .filter(e -> !(e instanceof StepExecutionEvent))
      .collect(Collectors.toList());
  }

  void send(ExecutionEvent executionEvent);

  void subscribe(IReport reporter);

}
