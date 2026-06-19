package com.project.sf.reservation.service;

import com.project.sf.common.enums.reservation.CanceledReasonEnum;
import com.project.sf.common.enums.reservation.InflowEnum;
import com.project.sf.common.enums.reservation.RegionEnum;
import com.project.sf.common.pager.AdminReservationSearch;
import com.project.sf.reservation.dao.ReservationDao;
import com.project.sf.reservation.model.Reservation;
import com.project.sf.reservation.model.SelectedKeyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  // 전체 사전예약 데이터 조회 (관리자용) -> 서비스 옮길 것!!
  @Override
  public List<Reservation> loadAllReservations(AdminReservationSearch pager) {
    int totalCountReservation = reservationDao.totalCountReservation(pager);

    pager.setTotal(totalCountReservation);
    pager.setPerPage(6);

    List<Reservation> reservations = reservationDao.loadAllReservations(pager);

    for (Reservation reservation : reservations) {
      // 비밀번호 제외
      reservation.setPassword(null);

      // DB에 저장된 영문을 한글로 변경
      reservation.setRegion(RegionEnum.changeValueToLabel(reservation.getRegion()));
      reservation.setInflow(InflowEnum.changeValueToLabel(reservation.getInflow()));

      // 취소 사유는 없을 수도 있으니 if문으로 처리
      if (reservation.getCanceledReason() != null) {
        reservation.setCanceledReason(CanceledReasonEnum.changeValueToLabel(reservation.getCanceledReason()));
      }

    }

    return reservations;
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

  // 관리자용 사용자 상세 조회 -> 서비스 옮길 것!
  @Override
  public Reservation findReservationDetailByEmail(Long no) {
    return reservationDao.findReservationDetailByEmail(no);
  }
}
