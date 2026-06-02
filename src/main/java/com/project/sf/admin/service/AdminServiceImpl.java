package com.project.sf.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.admin.AdminLogin;
import com.project.sf.admin.Admin;
import com.project.sf.admin.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  AdminDao adminDao;

  @Override
  public Admin login(AdminLogin adminLogin) {
    return adminDao.login(adminLogin);
  }

}
