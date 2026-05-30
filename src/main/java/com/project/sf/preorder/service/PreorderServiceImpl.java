package com.project.sf.preorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.preorder.Reservation;
import com.project.sf.preorder.dao.PreorderDao;

@Service
public class PreorderServiceImpl implements PreorderService {

  @Autowired
  PreorderDao preorderDao;

  @Override
  public void registerReserve(Reservation reservation) {
    preorderDao.registerReserve(reservation);
  }

  @Override
  public Reservation findReservationDetail(String email, String password) {
    Map<String, String> params = new HashMap<>();

    params.put("email", email);
    params.put("password", password);

    return preorderDao.findReservationDetail(params);
  }

  // 전체 사전예약 데이터 조회 (관리자용)
  @Override
  public List<Reservation> loadAllReservations() {
    return preorderDao.loadAllReservations();
  }

}
