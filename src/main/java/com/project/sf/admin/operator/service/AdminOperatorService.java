package com.project.sf.admin.operator.service;

import com.project.sf.admin.operator.model.Admin;
import com.project.sf.common.pager.Pager;

import java.util.List;

public interface AdminOperatorService {
  List<Admin> loadAdmins(Pager pager);

  Admin loadAdminDetailById(String id);
}
