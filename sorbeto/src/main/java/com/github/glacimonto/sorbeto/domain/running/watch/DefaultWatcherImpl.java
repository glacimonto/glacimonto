package com.github.glacimonto.sorbeto.domain.running.watch;

import com.github.glacimonto.sorbeto.domain.running.play.IPlay;
import com.github.glacimonto.sorbeto.domain.running.watch.event.ExecutionEvent;
import java.util.List;

public class DefaultWatcherImpl implements IWatch {

  @Override
  public void watch(IPlay player) {

  }

  @Override
  public List<ExecutionEvent> events() {
    return null;
  }

}