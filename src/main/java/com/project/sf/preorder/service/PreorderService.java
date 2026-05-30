package com.project.sf.preorder.service;

import java.util.List;
import com.project.sf.preorder.Reservation;

public interface PreorderService {

  List<Reservation> loadAllReservations();

  void registerReserve(Reservation reservation);

  Reservation findReservationDetail(String email, String password);

}
