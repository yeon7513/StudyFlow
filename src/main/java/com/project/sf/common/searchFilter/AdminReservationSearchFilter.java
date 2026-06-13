package com.project.sf.common.searchFilter;

import com.project.sf.common.searchFilter.constance.enums.reservation.*;

import java.util.ArrayList;
import java.util.List;

// 검색용 필터 옵션 렌더링 DTO
// 타임리프에서 하드코딩하기에는 HTML이 길어져서 가독성이 떨어짐
// 스프링 쪽에서 필터 옵션을 만들어 타임리프에 렌더링하는 게 깔끔해 보인다.
// -> 고정된 선택지를 화면에 렌더링하는 용도
// 즉, 초기 렌더링용이기 때문에 setter는 필요가 없다. -> 생성자로 값을 세팅함
public class AdminReservationSearchFilter {

  private final List<SearchFilterOption> reserveStates;
  private final List<SearchFilterOption> regions;
  private final List<SearchFilterOption> inflows;
  private final List<SearchFilterOption> canceledReasons;
  private final List<SearchFilterOption> reservationSearch;

  public AdminReservationSearchFilter() {
    this.reserveStates = new ArrayList<>();
    this.regions = new ArrayList<>();
    this.inflows = new ArrayList<>();
    this.canceledReasons = new ArrayList<>();
    this.reservationSearch = new ArrayList<>();

    // 예약 상태
    for (ReserveStateEnum reserveState : ReserveStateEnum.values()) {
      if (reserveState == ReserveStateEnum.ACTIVE) {
        // "예약중"만 활성화
        this.reserveStates.add(SearchFilterOption.selected(reserveState.getLabel(), reserveState.getValue()));
      } else {
        this.reserveStates.add(SearchFilterOption.of(reserveState.getLabel(), reserveState.getValue()));
      }
    }

    for (RegionEnum region : RegionEnum.values()) {
      this.regions.add(SearchFilterOption.of(region.getLabel(), region.getValue()));
    }

    for (InflowEnum inflow : InflowEnum.values()) {
      this.inflows.add(SearchFilterOption.of(inflow.getLabel(), inflow.getValue()));
    }

    for (CanceledReasonEnum canceledReason : CanceledReasonEnum.values()) {
      this.canceledReasons.add(SearchFilterOption.of(canceledReason.getLabel(), canceledReason.getValue()));
    }

    for (ReservationSearchEnum reservationSearch : ReservationSearchEnum.values()) {
      this.reservationSearch.add(SearchFilterOption.of(reservationSearch.getLabel(), reservationSearch.getValue()));
    }
  }

  public List<SearchFilterOption> getReserveStates() {
    return reserveStates;
  }

  public List<SearchFilterOption> getRegions() {
    return regions;
  }

  public List<SearchFilterOption> getInflows() {
    return inflows;
  }

  public List<SearchFilterOption> getCanceledReasons() {
    return canceledReasons;
  }

  public List<SearchFilterOption> getReservationSearch() {
    return reservationSearch;
  }
}
