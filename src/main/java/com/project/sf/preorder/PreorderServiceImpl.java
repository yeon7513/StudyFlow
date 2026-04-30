package com.project.sf.preorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreorderServiceImpl implements PreorderService {

  @Autowired
  PreorderDao preorderDao;

  @Override
  public void registerReserve() {
    // TODO Auto-generated method stub

  }



}
