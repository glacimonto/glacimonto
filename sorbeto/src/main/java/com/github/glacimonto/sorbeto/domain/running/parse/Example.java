package com.github.glacimonto.sorbeto.domain.running.parse;

import com.github.glacimonto.sorbeto.domain.ExecutionRequestId;

public class Example {

  private final ExecutionRequestId executionRequestId;

  public Example(ExecutionRequestId executionRequestId) {
    this.executionRequestId = executionRequestId;
  }

  @Override
  public int hashCode() {
    int hash = 17;
    if (executionRequestId != null) {
      hash = 31 * hash + executionRequestId.hashCode();
    }
    return hash;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Example))
      return false;
    Example other = (Example) o;

    return (this.executionRequestId == null && other.executionRequestId == null)
      || (this.executionRequestId != null && this.executionRequestId.equals(other.executionRequestId));
  }

}