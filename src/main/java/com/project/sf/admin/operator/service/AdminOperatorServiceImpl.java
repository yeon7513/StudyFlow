package com.project.sf.admin.operator.service;

import com.project.sf.admin.operator.dao.AdminOperatorDao;
import com.project.sf.admin.operator.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOperatorServiceImpl implements AdminOperatorService {

  @Autowired
  AdminOperatorDao adminOperatorDao;

  @Override
  public List<Admin> loadAdmins() {
    return adminOperatorDao.loadAdmins();
  }
}
