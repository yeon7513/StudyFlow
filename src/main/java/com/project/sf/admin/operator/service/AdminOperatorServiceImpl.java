package com.project.sf.admin.operator.service;


import com.project.sf.admin.operator.dao.AdminOperatorDao;
import com.project.sf.admin.operator.model.Admin;
import com.project.sf.common.enums.operator.AdminRoleEnum;
import com.project.sf.common.model.UpdateSuccess;
import com.project.sf.common.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdminOperatorServiceImpl implements AdminOperatorService {

  @Autowired
  AdminOperatorDao adminOperatorDao;

  UpdateSuccess updateSuccess = new UpdateSuccess();
  LocalDate now = LocalDate.now();

  @Override
  public List<Admin> loadAdmins(Pager pager) {

    List<Admin> admins = adminOperatorDao.loadAdmins(pager);

    for (Admin admin : admins) {
      admin.setRolesWithLabel(AdminRoleEnum.changeValueToLabel(admin.getRole()));
    }

    return admins;
  }

  @Override
  public Admin loadAdminDetailById(String id) {
    return adminOperatorDao.loadAdminDetailById(id);
  }

  @Override
  public UpdateSuccess modifyAdmin(Admin admin) {

    // 권한들을 문자열로 변경
    admin.getConvertRoleToDBFormat();
    admin.setUpdatedAt(String.valueOf(now));

    int updateSuccessRow = adminOperatorDao.modifyAdmin(admin);
    boolean isSuccess = updateSuccessRow == 1;

    updateSuccess.setSuccess(isSuccess);

    if (isSuccess) {
      updateSuccess.setUpdatedAt(String.valueOf(now));
    } else {
      updateSuccess.setMessage("관리자 정보 수정에 실패했습니다.");
    }

    return updateSuccess;
  }

  @Override
  public void registerAdminAccount(Admin admin) {
    admin.getConvertRoleToDBFormat();

    adminOperatorDao.registerAdminAccount(admin);
  }

  @Override
  public boolean checkId(String id) {

    // resultRow가 0이면? 사용 가능
    // 1이면? 사용 불가능 (이미 있으니까)
    int resultRow = adminOperatorDao.checkId(id);

    return resultRow == 0;
  }
}
