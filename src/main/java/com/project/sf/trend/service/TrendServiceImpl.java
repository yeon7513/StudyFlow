package com.project.sf.trend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.trend.Category;
import com.project.sf.trend.Keyword;
import com.project.sf.trend.dao.TrendDao;

@Service
public class TrendServiceImpl implements TrendService {

  @Autowired
  TrendDao trendDao;

  @Override
  public List<Category> findCategorys() {
    return null;
  }

  @Override
  public List<Keyword> loadKeywords() {
    return trendDao.loadKeywords();
  }

  @Override
  public List<Keyword> findTopKeywords() {
    return trendDao.findTopKeywords();
  }

  @Override
  public List<Category> loadCategories() {
    return trendDao.loadCategories();
  }

}
