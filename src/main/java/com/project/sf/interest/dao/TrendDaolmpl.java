package com.project.sf.interest.dao;

import com.project.sf.interest.Category;
import com.project.sf.interest.Keyword;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrendDaolmpl implements TrendDao {

    @Autowired
    SqlSession sql;

    @Override
    public List<Keyword> findTopKeywords() {
        return sql.selectList("trend.findTopKeywords");
    }

    @Override
    public List<Category> loadCategories() {
        return sql.selectList("trend.loadCategories");
    }

    @Override
    public List<Category> loadKeywords() {
        return sql.selectList("trend.loadKeywords");
    }

}
