package com.project.sf.admins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.admins.AdminLogin;
import com.project.sf.admins.Admins;
import com.project.sf.admins.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  AdminDao adminDao;

  @Override
  public Admins login(AdminLogin adminLogin) {
    return adminDao.login(adminLogin);
  }

}
