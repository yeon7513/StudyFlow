package com.project.sf.admin.interest.dao;

import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;
import com.project.sf.admin.interest.model.AdminInterestKeywordStats;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

  @Override
  public int countEmptyCategory() {
    return sql.selectOne("adminInterest.countEmptyCategory");
  }

  @Override
  public int countActiveKeyword() {
    return sql.selectOne("adminInterest.countActiveKeyword");
  }

  @Override
  public int countInactiveKeyword() {
    return sql.selectOne("adminInterest.countInactiveKeyword");
  }

  @Override
  public int updateCategoryName(Map<String, Object> params) {
    return sql.update("adminInterest.updateCategoryName", params);
  }

  @Override
  public int updateCategoryState(Map<String, Object> params) {
    return sql.update("adminInterest.updateCategoryState", params);
  }

  @Override
  public int updateKeywordState(Map<String, Object> params) {
    return sql.update("adminInterest.updateKeywordState", params);
  }

  @Override
  public AdminInterestKeyword loadKeywordDetail(Long no) {
    return sql.selectOne("adminInterest.loadKeywordDetail", no);
  }

  @Override
  public List<AdminInterestCategory> loadCategoryOptions() {
    return sql.selectList("adminInterest.loadCategoryOptions");
  }

  @Override
  public AdminInterestKeywordStats loadKeywordStatByNo(Long no) {
    return sql.selectOne("adminInterest.loadKeywordStatByNo", no);
  }

  @Override
  public int updateKeywordInfo(AdminInterestKeyword keyword) {
    return sql.update("adminInterest.updateKeywordInfo", keyword);
  }

  @Override
  public void registerCategory(AdminInterestCategory category) {
    sql.insert("adminInterest.registerCategory", category);
  }

  @Override
  public void registerKeyword(AdminInterestKeyword keyword) {
    sql.insert("adminInterest.registerKeyword", keyword);
  }
}
