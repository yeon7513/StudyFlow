package com.project.sf.admin.operator.service;

import com.project.sf.admin.operator.dao.AdminOperatorDao;
import com.project.sf.admin.operator.model.Admin;
import com.project.sf.common.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOperatorServiceImpl implements AdminOperatorService {

  @Autowired
  AdminOperatorDao adminOperatorDao;

  @Override
  public List<Admin> loadAdmins(Pager pager) {
    return adminOperatorDao.loadAdmins(pager);
  }

  @Override
  public Admin loadAdminDetailById(String id) {
    return adminOperatorDao.loadAdminDetailById(id);
  }
}
