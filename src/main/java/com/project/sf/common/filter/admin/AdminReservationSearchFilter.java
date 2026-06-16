package com.project.sf.common.filter.admin;

import com.project.sf.common.enums.reservation.*;
import com.project.sf.common.filter.SelectOption;

import java.util.ArrayList;
import java.util.List;

// 검색용 필터 옵션 렌더링 DTO
// 타임리프에서 하드코딩하기에는 HTML이 길어져서 가독성이 떨어짐
// 스프링 쪽에서 필터 옵션을 만들어 타임리프에 렌더링하는 게 깔끔해 보인다.
// -> 고정된 선택지를 화면에 렌더링하는 용도
// 즉, 초기 렌더링용이기 때문에 setter는 필요가 없다. -> 생성자로 값을 세팅함
public class AdminReservationSearchFilter {

  private final List<SelectOption> reserveStates;
  private final List<SelectOption> regions;
  private final List<SelectOption> inflows;
  private final List<SelectOption> canceledReasons;
  private final List<SelectOption> reservationSearch;

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
        this.reserveStates.add(SelectOption.selected(reserveState.getLabel(), reserveState.getValue()));
      } else {
        this.reserveStates.add(SelectOption.of(reserveState.getLabel(), reserveState.getValue()));
      }
    }

    for (RegionEnum region : RegionEnum.values()) {
      this.regions.add(SelectOption.of(region.getLabel(), region.getValue()));
    }

    for (InflowEnum inflow : InflowEnum.values()) {
      this.inflows.add(SelectOption.of(inflow.getLabel(), inflow.getValue()));
    }

    for (CanceledReasonEnum canceledReason : CanceledReasonEnum.values()) {
      this.canceledReasons.add(SelectOption.of(canceledReason.getLabel(), canceledReason.getValue()));
    }

    for (ReservationSearchEnum reservationSearch : ReservationSearchEnum.values()) {
      this.reservationSearch.add(SelectOption.of(reservationSearch.getLabel(), reservationSearch.getValue()));
    }
  }

  public List<SelectOption> getReserveStates() {
    return reserveStates;
  }

  public List<SelectOption> getRegions() {
    return regions;
  }

  public List<SelectOption> getInflows() {
    return inflows;
  }

  public List<SelectOption> getCanceledReasons() {
    return canceledReasons;
  }

  public List<SelectOption> getReservationSearch() {
    return reservationSearch;
  }
}
