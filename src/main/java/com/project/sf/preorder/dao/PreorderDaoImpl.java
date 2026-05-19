package com.project.sf.preorder.dao;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.preorder.Reservation;

@Repository
public class PreorderDaoImpl implements PreorderDao {

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

}
