package com.github.glacimonto.sorbeto.domain.running.play;

import com.github.glacimonto.sorbeto.domain.running.witness.ITell;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;

public class DefaultPlayerImpl implements IPlay {

  private final ITell teller;

  public DefaultPlayerImpl(ITell teller) {
    this.teller = teller;
  }

  @Override
  public void play(ScheduledExecution givenPendingExecution) {
  }

}