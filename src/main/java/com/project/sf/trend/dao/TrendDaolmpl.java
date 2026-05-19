package com.project.sf.trend.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.trend.Category;
import com.project.sf.trend.Keyword;

@Repository
public class TrendDaolmpl implements TrendDao {

  @Autowired
  SqlSession sql;

  @Override
  public List<Keyword> findTopKeywords() {
    return sql.selectList("trend.findTopKeywords");
  }

  @Override
  public List<Category> loadCategories() {
    return sql.selectList("trend.loadCategories");
  }

  @Override
  public List<Category> loadKeywords() {
    return sql.selectList("trend.loadKeywords");
  }

}
