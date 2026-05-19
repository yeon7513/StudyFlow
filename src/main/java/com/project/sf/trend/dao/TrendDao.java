package com.project.sf.trend.dao;

import java.util.List;
import com.project.sf.trend.Category;
import com.project.sf.trend.Keyword;

public interface TrendDao {

  List<Keyword> findTopKeywords();

  List<Category> loadCategories();

  List<Category> loadKeywords();

}
