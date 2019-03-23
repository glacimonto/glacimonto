package com.github.glacimonto.sorbeto.domain.running.witness;

import com.github.glacimonto.sorbeto.domain.running.witness.event.ExecutionEvent;

public interface IWatch {

  void watch(ExecutionEvent executionEvent);

}
