package com.github.glacimonto.sorbeto.domain;

import com.github.glacimonto.sorbeto.domain.reporting.TestCaseExecutionReport;

public interface Sorbeto {

  ExecutionRequestId execute(String testCase);

  TestCaseExecutionReport follow(ExecutionRequestId executionRequestId);

}