package com.project.sf.admin.interest.dao;

import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;

import java.util.List;

public interface AdminInterestDao {
  List<AdminInterestCategory> loadCategories();

  List<AdminInterestKeyword> loadKeywords();
}
