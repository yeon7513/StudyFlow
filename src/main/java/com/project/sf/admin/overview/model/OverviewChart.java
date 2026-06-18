package com.project.sf.admin.overview.model;

import java.util.ArrayList;
import java.util.List;

// 이 DTO 하나로 여러 종류의 차트를 그려낸다.
// DTO -> Data Transfer Object, 말 그대로 데이터가 왔다 갔다 하는 객체니까
public class OverviewChart {
  private final List<Integer> values = new ArrayList<>();
  private List<String> labels = new ArrayList<>();

  // 데이터를 추가하는 메소드
  // 즉, List에 값을 바로바로 집어넣기 위해 공통으로 사용함
  public void addData(String label, int value) {
    this.labels.add(label);
    this.values.add(value);
  }

  // getter, setter
  public List<String> getLabels() {
    return labels;
  }

  public void setLabels(List<String> labels) {
    this.labels = labels;
  }

  public List<Integer> getValues() {
    return values;
  }

  public void setValues(List<Integer> values) {
  }
}
