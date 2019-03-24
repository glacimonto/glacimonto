package com.github.glacimonto.sorbeto.domain.reporting;

import com.github.glacimonto.sorbeto.domain.running.witness.ExecutionReport;

public interface IRecord {

  void record(ExecutionReport report);

}
