package com.project.sf.admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.admin.AdminLogin;
import com.project.sf.admin.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

  @Autowired
  SqlSession sql;

  @Override
  public Admin login(AdminLogin adminLogin) {
    return sql.selectOne("admin.login", adminLogin);
  }



}
