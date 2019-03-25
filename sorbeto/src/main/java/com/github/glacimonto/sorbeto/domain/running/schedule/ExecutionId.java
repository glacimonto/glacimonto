package com.github.glacimonto.sorbeto.domain.running.schedule;

import java.util.Objects;

public final class ExecutionId {

  public static final ExecutionId NO_EXECUTION = new ExecutionId(-1L);

  private final Long id;

  public ExecutionId(long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ExecutionId{" +
      "id=" + id +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExecutionId that = (ExecutionId) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
