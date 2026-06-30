package com.project.sf.admin.operator.service;

import com.project.sf.admin.operator.model.Admin;
import com.project.sf.common.model.UpdateSuccess;
import com.project.sf.common.pager.Pager;

import java.util.List;

public interface AdminOperatorService {
  List<Admin> loadAdmins(Pager pager);

  Admin loadAdminDetailById(String id);

  UpdateSuccess modifyAdmin(Admin admin);

  void registerAdminAccount(Admin admin);

  boolean checkId(String id);
}
