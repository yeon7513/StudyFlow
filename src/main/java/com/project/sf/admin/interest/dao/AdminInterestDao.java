package com.project.sf.admin.interest.dao;

import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;
import com.project.sf.admin.interest.model.AdminInterestKeywordStats;

import java.util.List;
import java.util.Map;

public interface AdminInterestDao {
  List<AdminInterestCategory> loadCategories();

  List<AdminInterestKeyword> loadKeywords();

  int countEmptyCategory();

  int countActiveKeyword();

  int countInactiveKeyword();

  int updateCategoryName(Map<String, Object> params);

  int updateCategoryState(Map<String, Object> params);

  int updateKeywordState(Map<String, Object> params);

  AdminInterestKeyword loadKeywordDetail(Long no);

  List<AdminInterestCategory> loadCategoryOptions();

  AdminInterestKeywordStats loadKeywordStatByNo(Long no);

  int updateKeywordInfo(AdminInterestKeyword keyword);

  void registerCategory(AdminInterestCategory category);

  void registerKeyword(AdminInterestKeyword keyword);
}
