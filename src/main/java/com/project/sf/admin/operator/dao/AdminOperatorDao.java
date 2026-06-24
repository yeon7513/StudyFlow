package com.project.sf.admin.operator.dao;

import com.project.sf.admin.operator.model.Admin;
import com.project.sf.common.pager.Pager;

import java.util.List;

public interface AdminOperatorDao {
  List<Admin> loadAdmins(Pager pager);

  Admin loadAdminDetailById(String id);
}
