package com.project.sf.admin.auth.dao;

import com.project.sf.admin.auth.model.AdminLogin;
import com.project.sf.admin.operator.model.Admin;

public interface AdminAuthDao {

  Admin login(AdminLogin adminLogin);

}
