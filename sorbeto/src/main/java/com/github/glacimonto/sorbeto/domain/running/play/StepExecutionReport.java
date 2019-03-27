package com.github.glacimonto.sorbeto.domain.running.play;

import com.github.glacimonto.sorbeto.domain.running.compose.StepId;

public class StepExecutionReport {

  public final StepId stepId;
  public final String sentence;
  public final String result;


  public StepExecutionReport(StepId stepId, String sentence, String result) {
    this.stepId = stepId;
    this.sentence = sentence;
    this.result = result;
  }

  @Override
  public String toString() {
    return "StepExecutionReport{" +
      "stepId=" + stepId +
      ", sentence='" + sentence + '\'' +
      ", result='" + result + '\'' +
      '}';
  }

}
