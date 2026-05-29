package com.project.sf.admins.dao;

import com.project.sf.admins.AdminLogin;
import com.project.sf.admins.Admins;

public interface AdminDao {

  Admins login(AdminLogin adminLogin);

}
