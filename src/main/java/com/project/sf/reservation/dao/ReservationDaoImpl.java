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
  public void registerReserve(Reservation reservation) {
    sql.insert("preorder.registerReserve", reservation);
  }

  @Override
  public Reservation findReservationDetail(Map<String, String> params) {
    return sql.selectOne("preorder.findReservationDetail", params);
  }

  @Override
  public List<Reservation> loadAllReservations() {
    return sql.selectList("preorder.loadAllReservations");
  }

}
