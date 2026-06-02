package com.project.sf.admin.dao;

import com.project.sf.admin.AdminLogin;
import com.project.sf.admin.Admin;

public interface AdminDao {

  Admin login(AdminLogin adminLogin);

}
