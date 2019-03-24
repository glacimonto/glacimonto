package com.github.glacimonto.sorbeto.domain;

public class ExecutionRequestId {

  private final Long id;

  public ExecutionRequestId(long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return 17 * 31 + id.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ExecutionRequestId))
      return false;
    ExecutionRequestId other = (ExecutionRequestId) o;

    return this.id.equals(other.id);
  }

}
