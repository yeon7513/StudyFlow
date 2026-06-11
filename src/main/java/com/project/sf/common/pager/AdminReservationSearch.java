package com.project.sf.common.pager;

public class AdminReservationSearch extends AdminBaseSearch {
  private String reserveState; // "active", "canceled", "all"
  private String region;
  private String inflow;
  private String canceledReason;

  public String getReserveState() {
    return reserveState;
  }

  public void setReserveState(String reserveState) {
    this.reserveState = reserveState;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getInflow() {
    return inflow;
  }

  public void setInflow(String inflow) {
    this.inflow = inflow;
  }

  public String getCanceledReason() {
    return canceledReason;
  }

  public void setCanceledReason(String canceledReason) {
    this.canceledReason = canceledReason;
  }

}
