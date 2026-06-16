package com.project.sf.common.pager;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AdminInquiryPostSearch extends AdminBaseSearch {
  private String answerState; // "answered", "waiting", "all"
  private List<String> category = new ArrayList<>();

  @Override
  public String getQuery() {
    StringBuilder query = new StringBuilder();

    appendQuery(query, "answerState", answerState);

    if (getCategory() != null && !getCategory().isEmpty()) {
      appendQueryList(query, "category", category);
    }

    if (getStartDate() != null && !getStartDate().isBlank()) {
      appendQuery(query, "startDate", getStartDate());
    }

    if (getEndDate() != null && !getEndDate().isBlank()) {
      appendQuery(query, "endDate", getEndDate());
    }

    if (getKeyword() != null && !getKeyword().isBlank()) {
      appendQuery(query, "search", getSearch());
      appendQuery(query, "keyword", getKeyword());
    }

    return query.toString();
  }

  private void appendQuery(StringBuilder query, String name, String value) {
    if (value == null || value.isBlank()) {
      return;
    }

    query.append("&")
      .append(name)
      .append("=")
      .append(URLEncoder.encode(value, StandardCharsets.UTF_8));
  }

  private void appendQueryList(StringBuilder query, String name, List<String> values) {
    if (values == null || values.isEmpty()) {
      return;
    }

    for (String value : values) {
      if (value == null || value.isBlank()) {
        continue;
      }

      appendQuery(query, name, value);
    }
  }

  // getter, setter
  public String getAnswerState() {
    return answerState;
  }

  public void setAnswerState(String answerState) {
    this.answerState = answerState;
  }

  public List<String> getCategory() {
    return category;
  }

  public void setCategory(List<String> category) {
    this.category = category;
  }

}
