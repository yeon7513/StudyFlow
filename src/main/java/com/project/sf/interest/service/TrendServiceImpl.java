package com.project.sf.interest.service;

import com.project.sf.interest.Category;
import com.project.sf.interest.Keyword;
import com.project.sf.interest.dao.TrendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrendServiceImpl implements TrendService {

    @Autowired
    TrendDao trendDao;

    @Override
    public List<Category> findCategorys() {
        return null;
    }

    @Override
    public List<Keyword> findTopKeywords() {
        return trendDao.findTopKeywords();
    }

    @Override
    public List<Category> loadCategories() {
        return trendDao.loadCategories();
    }

    @Override
    public List<Category> loadKeywords() {
        return trendDao.loadKeywords();
    }

}
