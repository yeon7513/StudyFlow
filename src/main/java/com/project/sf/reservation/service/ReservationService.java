package com.project.sf.reservation.service;

import com.project.sf.common.pager.AdminReservationSearch;
import com.project.sf.reservation.model.Reservation;
import com.project.sf.reservation.model.SelectedKeyword;

import java.util.List;

public interface ReservationService {

  List<Reservation> loadAllReservations(AdminReservationSearch adminQnaPostSearch);

  Reservation findReservationDetail(String email, String password);

  Long registerReserve(Reservation reservation);

  void registerSelectedKeywords(Long newRsvNo, List<SelectedKeyword> selectedKeywords);

  Reservation findReservationDetailByEmail(Long no);

}
