package com.github.glacimonto.sorbeto.domain;

import java.util.Objects;

public class RawTestCase {

  public final String rawTestCase;

  public RawTestCase(String rawTestCase) {
    this.rawTestCase = rawTestCase;
  }

  @Override
  public String toString() {
    return "RawTestCase{" +
      "rawTestCase='" + rawTestCase + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RawTestCase that = (RawTestCase) o;
    return rawTestCase.equals(that.rawTestCase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawTestCase);
  }

}
