package com.project.sf.common.pager;

public class AdminQnaPostSearch extends AdminBaseSearch {
  private String answerState; // "answered", "waiting", "all"

  public String getAnswerState() {
    return answerState;
  }

  public void setAnswerState(String answerState) {
    this.answerState = answerState;
  }

}
