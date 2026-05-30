package com.project.sf.preorder.dao;

import java.util.List;
import java.util.Map;
import com.project.sf.preorder.Reservation;

public interface PreorderDao {

  void registerReserve(Reservation reservation);

  Reservation findReservationDetail(Map<String, String> params);

  List<Reservation> loadAllReservations();

}
