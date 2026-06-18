package com.project.sf.admin.auth.service;

import com.project.sf.admin.auth.dao.AdminAuthDao;
import com.project.sf.admin.auth.model.Admin;
import com.project.sf.admin.auth.model.AdminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthServiceImpl implements AdminAuthService {

  @Autowired
  AdminAuthDao adminDao;

  @Override
  public Admin login(AdminLogin adminLogin) {
    return adminDao.login(adminLogin);
  }

}
