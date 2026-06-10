package com.project.sf.reservation.service;

import java.util.List;
import com.project.sf.common.pager.AdminReservationSearch;
import com.project.sf.reservation.Reservation;
import com.project.sf.reservation.SelectedKeyword;

public interface ReservationService {

  List<Reservation> loadAllReservations(AdminReservationSearch adminQnaPostSearch);

  Reservation findReservationDetail(String email, String password);

  Long registerReserve(Reservation reservation);

  void registerSelectedKeywords(Long newRsvNo, List<SelectedKeyword> selectedKeywords);

  Reservation findReservationDetailByEmail(Long no);

}
