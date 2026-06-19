package com.project.sf.reservation.dao;

import com.project.sf.common.pager.AdminReservationSearch;
import com.project.sf.common.pager.Pager;
import com.project.sf.reservation.model.Reservation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReservationDaoImpl implements ReservationDao {

  @Autowired
  SqlSession sql;

  @Override
  public Long registerReserve(Reservation reservation) {
    sql.insert("reservation.registerReserve", reservation);

    return reservation.getNo();
  }

  @Override
  public Reservation findReservationDetail(Map<String, String> params) {
    return sql.selectOne("reservation.findReservationDetail", params);
  }

  @Override
  public void registerSelectedKeywords(Map<String, Object> params) {
    sql.insert("reservation.registerSelectedKeywords", params);
  }

  // 관리자용
  @Override
  public List<Reservation> loadAllReservations(AdminReservationSearch pager) {
    return sql.selectList("adminReservation.loadAllReservations", pager);
  }

  @Override
  public int totalCountReservation(Pager pager) {
    return sql.selectOne("adminReservation.totalCountReservation", pager);
  }

  @Override
  public Reservation findReservationDetailByEmail(Long no) {
    return sql.selectOne("adminReservation.findReservationDetailByEmail", no);
  }


}
