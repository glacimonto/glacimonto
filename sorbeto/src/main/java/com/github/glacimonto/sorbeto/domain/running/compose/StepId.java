package com.github.glacimonto.sorbeto.domain.running.compose;

import java.util.Objects;

public class StepId {

  public final Long id;

  public StepId(long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "StepId{" +
      "id=" + id +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StepId that = (StepId) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}