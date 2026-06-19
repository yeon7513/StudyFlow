package com.project.sf.admin.interest.service;

import com.project.sf.admin.interest.dao.AdminInterestDao;
import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminInterestServiceImpl implements AdminInterestService {

  @Autowired
  AdminInterestDao adminInterestDao;

  @Override
  public List<AdminInterestCategory> loadCategories() {
    return adminInterestDao.loadCategories();
  }

  @Override
  public List<AdminInterestKeyword> loadKeywords() {
    return adminInterestDao.loadKeywords();
  }

  @Override
  public int totalCategoryCount() {
    return 0;
  }

  @Override
  public int totalKeywordCount() {
    return 0;
  }
}
