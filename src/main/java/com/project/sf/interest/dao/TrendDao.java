package com.project.sf.interest.dao;

import com.project.sf.interest.Category;
import com.project.sf.interest.Keyword;

import java.util.List;

public interface TrendDao {

    List<Keyword> findTopKeywords();

    List<Category> loadCategories();

    List<Category> loadKeywords();

}
