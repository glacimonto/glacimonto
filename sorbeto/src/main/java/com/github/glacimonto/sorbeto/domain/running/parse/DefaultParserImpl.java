package com.github.glacimonto.sorbeto.domain.running.parse;

public class DefaultParserImpl implements IParse {

  @Override
  public Example parse(String testCase) {
    return new Example();
  }

}
