package com.github.glacimonto.sorbeto.domain.running.play;

import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.witness.IWatch;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEndedEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionStartedEvent;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DefaultPlayerImpl implements IPlay {

  private final IWatch watcher;

  public DefaultPlayerImpl(IWatch watcher) {
    this.watcher = watcher;
  }

  @Override
  public void play(ScheduledExecution pendingExecution) {
    Function<ExecutionEvent, ExecutionEvent> notify = e -> { watcher.watch(e); return e; };

    watcher.watch(new ExecutionStartedEvent(pendingExecution.id()));

    pendingExecution
      .plan()
      .play(notify)
    .collect(Collectors.toList());

    watcher.watch(new ExecutionEndedEvent(pendingExecution.id()));
  }



}