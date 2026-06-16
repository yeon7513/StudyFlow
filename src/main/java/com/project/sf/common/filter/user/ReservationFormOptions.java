package com.project.sf.common.filter.user;

import com.project.sf.common.enums.reservation.InflowEnum;
import com.project.sf.common.enums.reservation.RegionEnum;
import com.project.sf.common.filter.SelectOption;

import java.util.ArrayList;
import java.util.List;

// 사전 예약 시 선택 옵션들이 전부 하드코딩 되어있음.
// enum으로 관리하는 김에 사용자용으로 따로 관리하는 것이 낫겠다 판단됨.
public class ReservationFormOptions {
  private final List<SelectOption> regions;
  private final List<SelectOption> inflows;

  public ReservationFormOptions() {
    this.regions = new ArrayList<>();
    this.inflows = new ArrayList<>();

    for (RegionEnum region : RegionEnum.values()) {
      this.regions.add(SelectOption.of(region.getLabel(), region.getValue()));
    }

    for (InflowEnum inflow : InflowEnum.values()) {
      this.inflows.add(SelectOption.of(inflow.getLabel(), inflow.getValue()));
    }
  }

  public List<SelectOption> getRegions() {
    return regions;
  }

  public List<SelectOption> getInflows() {
    return inflows;
  }
}
