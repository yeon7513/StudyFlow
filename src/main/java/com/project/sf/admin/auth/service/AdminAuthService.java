package com.project.sf.admin.auth.service;

import com.project.sf.admin.auth.model.Admin;
import com.project.sf.admin.auth.model.AdminLogin;

public interface AdminAuthService {
  Admin login(AdminLogin adminLogin);
}
