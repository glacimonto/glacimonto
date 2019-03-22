package com.github.glacimonto.sorbeto.domain.running.play;

import com.github.glacimonto.sorbeto.domain.running.watch.IWatch;
import com.github.glacimonto.sorbeto.domain.running.schedule.ScheduledExecution;
import java.util.ArrayList;
import java.util.List;

public class Player implements IPlay {

  private final List<IWatch> observers = new ArrayList<>();

  @Override
  public void play(ScheduledExecution givenPendingExecution) {
  }

  @Override
  public void subscribe(IWatch observer) {
    observers.add(observer);
  }

}