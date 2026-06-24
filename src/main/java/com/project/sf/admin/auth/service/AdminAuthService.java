package com.project.sf.admin.auth.service;

import com.project.sf.admin.auth.model.AdminLogin;
import com.project.sf.admin.operator.model.Admin;

public interface AdminAuthService {
  Admin login(AdminLogin adminLogin);
}
