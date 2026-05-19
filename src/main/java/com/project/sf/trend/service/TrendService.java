package com.project.sf.trend.service;

import java.util.List;
import com.project.sf.trend.Category;
import com.project.sf.trend.Keyword;

public interface TrendService {

  List<Category> findCategorys();

  List<Keyword> findTopKeywords();

  List<Category> loadCategories();

  List<Category> loadKeywords();

}
