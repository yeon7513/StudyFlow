package com.project.sf.preorder.service;

import com.project.sf.preorder.Reservation;

public interface PreorderService {

  void registerReserve(Reservation reservation);

  Reservation findReservationDetail(String email, String ip);

}
