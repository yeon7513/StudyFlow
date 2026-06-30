package com.project.sf.admin.interest.service;

import com.project.sf.admin.interest.dao.AdminInterestDao;
import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;
import com.project.sf.admin.interest.model.AdminInterestKeywordStats;
import com.project.sf.admin.interest.model.AdminInterestWidget;
import com.project.sf.common.model.UpdateSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminInterestServiceImpl implements AdminInterestService {

  @Autowired
  AdminInterestDao adminInterestDao;

  UpdateSuccess updateSuccess = new UpdateSuccess();
  // 현재 날짜 구하기
  LocalDate now = LocalDate.now();


  @Override
  public List<AdminInterestCategory> loadCategories() {
    return adminInterestDao.loadCategories();
  }

  @Override
  public List<AdminInterestKeyword> loadKeywords() {
    return adminInterestDao.loadKeywords();
  }

  @Override
  public AdminInterestWidget loadInterestWidgetData() {
    AdminInterestWidget widget = new AdminInterestWidget();

    widget.setTotalCategory(loadCategories().size());
    widget.setEmptyCategory(countEmptyCategory());
    widget.setActiveCategory(countActiveCategory());
    widget.setInactiveCategory(countInactiveCategory());

    widget.setTotalKeyword(loadKeywords().size());
    widget.setActiveKeyword(countActiveKeyword());
    widget.setInactiveKeyword(countInactiveKeyword());

    return widget;
  }

  @Override
  public UpdateSuccess updateCategoryName(Long no, String name) {
    Map<String, Object> params = new HashMap<>();
    params.put("no", no);
    params.put("name", name);
    params.put("updatedAt", now);

    int updateSussessRow = adminInterestDao.updateCategoryName(params);
    boolean isSuccess = updateSussessRow == 1;

    updateSuccess.setSuccess(isSuccess);

    if (isSuccess) {
      updateSuccess.setUpdatedAt(String.valueOf(now));
    } else {
      updateSuccess.setMessage("카테고리명 수정에 실패했습니다.");
    }
    return updateSuccess;
  }

  @Override
  public UpdateSuccess updateCategoryState(Long no, boolean isActive) {
    Map<String, Object> params = new HashMap<>();
    params.put("no", no);
    params.put("isActive", isActive);
    params.put("updatedAt", now);

    int updateSussessRow = adminInterestDao.updateCategoryState(params);
    boolean isSuccess = updateSussessRow == 1;

    updateSuccess.setSuccess(isSuccess);

    if (isSuccess) {
      updateSuccess.setUpdatedAt(String.valueOf(now));
    } else {
      updateSuccess.setMessage("카테고리 활성 상태 변경에 실패했습니다.");
    }

    return updateSuccess;
  }

  @Override
  public UpdateSuccess updateKeywordState(Long no, boolean isActive) {
    Map<String, Object> params = new HashMap<>();
    params.put("no", no);
    params.put("isActive", isActive);
    params.put("updatedAt", now);

    int updateSussessRow = adminInterestDao.updateKeywordState(params);
    boolean isSuccess = updateSussessRow == 1;

    updateSuccess.setSuccess(isSuccess);

    if (isSuccess) {
      updateSuccess.setUpdatedAt(String.valueOf(now));
    } else {
      updateSuccess.setMessage("키워드 활성 상태 변경에 실패했습니다.");
    }

    return updateSuccess;
  }

  @Override
  public AdminInterestKeyword loadKeywordDetail(Long no) {
    return adminInterestDao.loadKeywordDetail(no);
  }

  @Override
  public List<AdminInterestCategory> loadCategoryOptions() {
    return adminInterestDao.loadCategoryOptions();
  }

  @Override
  public AdminInterestKeywordStats loadKeywordStatByNo(Long no) {
    return adminInterestDao.loadKeywordStatByNo(no);
  }

  @Override
  public UpdateSuccess updateKeywordInfo(Long no, AdminInterestKeyword keyword) {
    keyword.setNo(no);
    keyword.setUpdatedAt(String.valueOf(now));

    int updateSussessRow = adminInterestDao.updateKeywordInfo(keyword);
    boolean isSuccess = updateSussessRow == 1;

    updateSuccess.setSuccess(isSuccess);

    if (isSuccess) {
      updateSuccess.setUpdatedAt(String.valueOf(now));
    } else {
      updateSuccess.setMessage("키워드 정보 변경에 실패했습니다.");
    }

    return updateSuccess;
  }

  @Override
  public void registerCategory(AdminInterestCategory category) {
    adminInterestDao.registerCategory(category);
  }

  @Override
  public void registerKeyword(AdminInterestKeyword keyword) {
    adminInterestDao.registerKeyword(keyword);
  }

  // 위젯용 -> 컨트롤러는 알 필요 X
  private int countEmptyCategory() {
    return adminInterestDao.countEmptyCategory();
  }

  private int countActiveCategory() {
    return loadCategories().size() - countEmptyCategory();
  }

  private int countInactiveCategory() {
    return loadCategories().size() - countActiveCategory();
  }

  private int countActiveKeyword() {
    return adminInterestDao.countActiveKeyword();
  }

  private int countInactiveKeyword() {
    return adminInterestDao.countInactiveKeyword();
  }
}
