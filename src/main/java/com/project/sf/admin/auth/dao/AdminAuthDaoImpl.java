package com.project.sf.admin.auth.dao;

import com.project.sf.admin.auth.model.AdminLogin;
import com.project.sf.admin.operator.model.Admin;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminAuthDaoImpl implements AdminAuthDao {

  @Autowired
  SqlSession sql;

  @Override
  public Admin login(AdminLogin adminLogin) {
    return sql.selectOne("adminAuth.login", adminLogin);
  }


}
