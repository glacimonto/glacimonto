package com.github.glacimonto.sorbeto.domain.running;

import java.util.Objects;

public final class ExecutionRequestId {

  private final Long id;

  public ExecutionRequestId(long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ExecutionRequestId{" +
      "id=" + id +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExecutionRequestId that = (ExecutionRequestId) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
