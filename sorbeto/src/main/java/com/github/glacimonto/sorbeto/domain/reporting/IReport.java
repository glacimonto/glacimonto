package com.github.glacimonto.sorbeto.domain.reporting;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;

public interface IReport {

  TestCaseExecutionReport follow(ExecutionRequestId executionRequestId); // follow, watch, observe ?

}
