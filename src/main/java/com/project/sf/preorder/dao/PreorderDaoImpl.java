package com.project.sf.preorder.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.trend.Category;

@Repository
public class PreorderDaoImpl implements PreorderDao {

  @Autowired
  SqlSession sql;

  @Override
  public List<Category> loadKeywords() {
    return sql.selectList("preorder.loadKeywords");
  }

}
