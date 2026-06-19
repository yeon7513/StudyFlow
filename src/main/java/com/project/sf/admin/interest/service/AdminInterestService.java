package com.project.sf.admin.interest.service;

import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;

import java.util.List;

public interface AdminInterestService {
  List<AdminInterestCategory> loadCategories();

  List<AdminInterestKeyword> loadKeywords();

  int totalCategoryCount();

  int totalKeywordCount();
}
