package com.github.glacimonto.sorbeto.domain.running.witness.event;

import com.github.glacimonto.sorbeto.domain.running.schedule.ExecutionId;

public interface ExecutionEvent {

  ExecutionId executionId();

  String type();

}