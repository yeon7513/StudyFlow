package com.project.sf.interest.service;

import com.project.sf.interest.Category;
import com.project.sf.interest.Keyword;

import java.util.List;

public interface TrendService {

    List<Category> findCategorys();

    List<Keyword> findTopKeywords();

    List<Category> loadCategories();

    List<Category> loadKeywords();

}
