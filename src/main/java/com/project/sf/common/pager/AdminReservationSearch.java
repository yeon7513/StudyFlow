package com.project.sf.common.pager;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

// 실제 검색에 대한 값을 DB로 넘기기위해 만든 DTO
// 여기에 있는 필드들이 매퍼의 WHERE에 매핑된다.
public class AdminReservationSearch extends AdminBaseSearch {
  private String reserveState; // "active", "canceled", "all"
  private List<String> region = new ArrayList<>(); // 지역
  private List<String> inflow = new ArrayList<>(); // 유입경로
  private List<String> canceledReason = new ArrayList<>(); // 취소 사유

  // getQuery 오버라이드
  // -> 페이지네이션의 경로를 유지하기 위해 오버라이드
  @Override
  public String getQuery() {
    StringBuilder query = new StringBuilder();

    appendQuery(query, "reserveState", reserveState);

    if (getRegion() != null && !getRegion().isEmpty()) {
      appendQueryList(query, "region", region);
    }

    if (getInflow() != null && !getInflow().isEmpty()) {
      appendQueryList(query, "inflow", inflow);
    }

    if (getCanceledReason() != null && !getCanceledReason().isEmpty()) {
      appendQueryList(query, "canceledReason", canceledReason);
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

  // GETTERS & SETTERS
  public String getReserveState() {
    return reserveState;
  }

  public void setReserveState(String reserveState) {
    this.reserveState = reserveState;
  }

  public List<String> getRegion() {
    return region;
  }

  public void setRegion(List<String> region) {
    this.region = region;
  }

  public List<String> getInflow() {
    return inflow;
  }

  public void setInflow(List<String> inflow) {
    this.inflow = inflow;
  }

  public List<String> getCanceledReason() {
    return canceledReason;
  }

  public void setCanceledReason(List<String> canceledReason) {
    this.canceledReason = canceledReason;
  }
}
