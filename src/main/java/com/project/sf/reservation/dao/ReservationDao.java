package com.project.sf.reservation.dao;

import com.project.sf.common.pager.AdminReservationSearch;
import com.project.sf.common.pager.Pager;
import com.project.sf.reservation.model.Reservation;

import java.util.List;
import java.util.Map;

public interface ReservationDao {

  Long registerReserve(Reservation reservation);

  Reservation findReservationDetail(Map<String, String> params);

  List<Reservation> loadAllReservations(AdminReservationSearch pager);

  void registerSelectedKeywords(Map<String, Object> params);

  int totalCountReservation(Pager pager);

  Reservation findReservationDetailByEmail(Long no);

}
