package com.project.sf.admin.operator.dao;

import com.project.sf.admin.operator.model.Admin;

import java.util.List;

public interface AdminOperatorDao {
  List<Admin> loadAdmins();
}
