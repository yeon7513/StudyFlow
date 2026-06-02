package com.project.sf.reservation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.reservation.Reservation;
import com.project.sf.reservation.SelectedKeyword;
import com.project.sf.reservation.dao.ReservationDao;

@Service
public class ReservationServiceImpl implements ReservationService {

  @Autowired
  ReservationDao reservationDao;

  @Override
  public Reservation findReservationDetail(String email, String password) {
    Map<String, String> params = new HashMap<>();

    params.put("email", email);
    params.put("password", password);

    return reservationDao.findReservationDetail(params);
  }

  // 전체 사전예약 데이터 조회 (관리자용)
  @Override
  public List<Reservation> loadAllReservations() {
    return reservationDao.loadAllReservations();
  }

  @Override
  public void registerSelectedKeywords(Long newRsvNo, List<SelectedKeyword> selectedKeywords) {
    Map<String, Object> params = new HashMap<>();

    params.put("rsvNo", newRsvNo);
    params.put("selectedKeywords", selectedKeywords);

    reservationDao.registerSelectedKeywords(params);
  }

  @Override
  public Long registerReserve(Reservation reservation) {
    return reservationDao.registerReserve(reservation);
  }



}
