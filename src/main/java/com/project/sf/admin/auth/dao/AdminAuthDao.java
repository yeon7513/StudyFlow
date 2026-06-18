package com.project.sf.admin.auth.dao;

import com.project.sf.admin.auth.model.Admin;
import com.project.sf.admin.auth.model.AdminLogin;

public interface AdminAuthDao {

  Admin login(AdminLogin adminLogin);

}
