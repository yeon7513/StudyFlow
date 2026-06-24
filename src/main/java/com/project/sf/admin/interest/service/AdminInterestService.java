package com.project.sf.admin.interest.service;

import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;
import com.project.sf.admin.interest.model.AdminInterestKeywordStats;
import com.project.sf.admin.interest.model.AdminInterestWidget;
import com.project.sf.common.model.UpdateSuccess;

import java.util.List;

public interface AdminInterestService {
  List<AdminInterestCategory> loadCategories();

  List<AdminInterestKeyword> loadKeywords();

  AdminInterestWidget loadInterestWidgetData();

  UpdateSuccess updateCategoryName(Long no, String name);

  UpdateSuccess updateCategoryState(Long no, boolean isActive);

  UpdateSuccess updateKeywordState(Long no, boolean isActive);

  AdminInterestKeyword loadKeywordDetail(Long no);

  List<AdminInterestCategory> loadCategoryOptions();

  AdminInterestKeywordStats loadKeywordStatByNo(Long no);

  UpdateSuccess updateKeywordInfo(Long no, AdminInterestKeyword keyword);

  void registerCategory(AdminInterestCategory category);
}
