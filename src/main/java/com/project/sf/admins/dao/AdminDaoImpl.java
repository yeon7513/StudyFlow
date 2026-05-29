package com.project.sf.admins.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.admins.AdminLogin;
import com.project.sf.admins.Admins;

@Repository
public class AdminDaoImpl implements AdminDao {

  @Autowired
  SqlSession sql;

  @Override
  public Admins login(AdminLogin adminLogin) {
    return sql.selectOne("admin.login", adminLogin);
  }



}
