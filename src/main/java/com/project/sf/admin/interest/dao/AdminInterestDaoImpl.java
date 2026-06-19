package com.project.sf.admin.interest.dao;

import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminInterestDaoImpl implements AdminInterestDao {

  @Autowired
  SqlSession sql;

  @Override
  public List<AdminInterestCategory> loadCategories() {
    return sql.selectList("adminInterest.loadCategories");
  }

  @Override
  public List<AdminInterestKeyword> loadKeywords() {
    return sql.selectList("adminInterest.loadKeywords");
  }
}
