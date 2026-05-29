package com.project.sf.admins.service;

import com.project.sf.admins.AdminLogin;
import com.project.sf.admins.Admins;

public interface AdminService {

  Admins login(AdminLogin adminLogin);

}
