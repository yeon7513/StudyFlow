package com.project.sf.preorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.preorder.dao.PreorderDao;

@Service
public class PreorderServiceImpl implements PreorderService {

  @Autowired
  PreorderDao preorderDao;

  @Override
  public void registerReserve() {
    // TODO Auto-generated method stub

  }



}
