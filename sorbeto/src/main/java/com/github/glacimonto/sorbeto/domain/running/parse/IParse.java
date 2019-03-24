package com.github.glacimonto.sorbeto.domain.running.parse;

import com.github.glacimonto.sorbeto.domain.running.ExecutionRequestId;

public interface IParse {

  Example parse(ExecutionRequestId executionRequestId, String testCase);

}
