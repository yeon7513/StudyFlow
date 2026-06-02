package com.project.sf.reservation.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.reservation.Reservation;

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
  public List<Reservation> loadAllReservations() {
    return sql.selectList("reservation.loadAllReservations");
  }

  @Override
  public void registerSelectedKeywords(Map<String, Object> params) {
    sql.insert("reservation.registerSelectedKeywords", params);
  }


}
