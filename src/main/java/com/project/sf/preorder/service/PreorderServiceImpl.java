package com.project.sf.preorder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.preorder.dao.PreorderDao;
import com.project.sf.trend.Category;

@Service
public class PreorderServiceImpl implements PreorderService {

  @Autowired
  PreorderDao preorderDao;

  @Override
  public void registerReserve() {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Category> loadKeywords() {
    return preorderDao.loadKeywords();
  }



}
