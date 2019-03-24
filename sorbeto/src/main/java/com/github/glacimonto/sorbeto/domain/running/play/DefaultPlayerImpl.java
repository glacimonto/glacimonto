package com.github.glacimonto.sorbeto.domain.running.play;

import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import com.github.glacimonto.sorbeto.domain.running.witness.IWatch;
import com.github.glacimonto.sorbeto.domain.running.witness.event.EndedEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.PlayingEvent;
import com.github.glacimonto.sorbeto.domain.running.witness.event.StepSucceedEvent;

public class DefaultPlayerImpl implements IPlay {

  private final IWatch watcher;

  public DefaultPlayerImpl(IWatch watcher) {
    this.watcher = watcher;
  }

  @Override
  public void play(ScheduledExecution pendingExecution) {
    watcher.watch(new PlayingEvent(pendingExecution.id()));
    watcher.watch(new StepSucceedEvent(pendingExecution.id()));
    watcher.watch(new EndedEvent(pendingExecution.id()));
  }

}