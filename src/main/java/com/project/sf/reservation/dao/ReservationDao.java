package com.project.sf.reservation.dao;

import java.util.List;
import java.util.Map;
import com.project.sf.reservation.Reservation;

public interface ReservationDao {

  void registerReserve(Reservation reservation);

  Reservation findReservationDetail(Map<String, String> params);

  List<Reservation> loadAllReservations();

}
