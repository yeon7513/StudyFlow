package com.project.sf.reservation.service;

import java.util.List;
import com.project.sf.reservation.Reservation;

public interface ReservationService {

  List<Reservation> loadAllReservations();

  void registerReserve(Reservation reservation);

  Reservation findReservationDetail(String email, String password);

}
