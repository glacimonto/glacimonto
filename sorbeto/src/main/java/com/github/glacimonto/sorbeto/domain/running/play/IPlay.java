package com.github.glacimonto.sorbeto.domain.running.play;

import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;

public interface IPlay {

  void play(ScheduledExecution givenPendingExecution);

}
