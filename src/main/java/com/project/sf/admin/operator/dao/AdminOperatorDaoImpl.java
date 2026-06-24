package com.project.sf.admin.operator.dao;

import com.project.sf.admin.operator.model.Admin;
import com.project.sf.common.pager.Pager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminOperatorDaoImpl implements AdminOperatorDao {

  @Autowired
  SqlSession sql;

  @Override
  public List<Admin> loadAdmins(Pager pager) {
    return sql.selectList("adminOperator.loadAdmins", pager);
  }

  @Override
  public Admin loadAdminDetailById(String id) {
    return sql.selectOne("adminOperator.loadAdminDetailById", id);
  }
}
