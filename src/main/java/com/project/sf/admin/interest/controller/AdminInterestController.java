package com.project.sf.admin.interest.controller;

import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;
import com.project.sf.admin.interest.model.AdminInterestKeywordStats;
import com.project.sf.admin.interest.model.AdminInterestWidget;
import com.project.sf.admin.interest.service.AdminInterestService;
import com.project.sf.admin.operator.model.Admin;
import com.project.sf.common.model.UpdateSuccess;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/management/interest")
public class AdminInterestController {

  @Autowired
  AdminInterestService adminInterestService;

  // 관심 분야 관리 렌더링
  @GetMapping("/list")
  String list(Model model) {

    // 관심 분야 위젯
    AdminInterestWidget widget = adminInterestService.loadInterestWidgetData();
    model.addAttribute("widget", widget);

    // 최초 진입 시에는 카테고리 패널 렌더링
    List<AdminInterestCategory> categories = adminInterestService.loadCategories();
    model.addAttribute("categories", categories);

    return "pages/admin/management/interest/list";
  }

  // 카테고리 패널 렌더링
  @GetMapping("/category")
  String category(Model model) {

    List<AdminInterestCategory> categories = adminInterestService.loadCategories();

    model.addAttribute("categories", categories);

    return "layout/admin/fragments/interest/category_panel :: CategoryPanel";
  }

  // 키워드 패널 렌더링
  @GetMapping("/keyword")
  String keyword(Model model) {

    List<AdminInterestKeyword> keywords = adminInterestService.loadKeywords();

    model.addAttribute("keywords", keywords);

    // 모달에서 사용
    List<AdminInterestCategory> categoryOptions = adminInterestService.loadCategoryOptions();
    model.addAttribute("categoryOptions", categoryOptions);

    return "layout/admin/fragments/interest/keyword_panel :: KeywordPanel";
  }

  // 키워드 상세 정보 조회
  @GetMapping("/keyword/detail/{no}")
  String keywordDetail(@PathVariable Long no, Model model) {

    AdminInterestKeyword keyword = adminInterestService.loadKeywordDetail(no);
    model.addAttribute("keyword", keyword);

    AdminInterestKeywordStats stats = adminInterestService.loadKeywordStatByNo(no);
    model.addAttribute("stats", stats);

    return "layout/admin/fragments/interest/keyword_detail :: KeywordDetail";
  }

  // 키워드 수정 모드 전환
  @GetMapping("/keyword/modify/{no}")
  String keywordModify(@PathVariable Long no, Model model) {

    AdminInterestKeyword keyword = adminInterestService.loadKeywordDetail(no);

    // 키워드가 속한 카테고리 변경을 위해 카테고리 번호 & 카테고리명은 따로 가져옴
    List<AdminInterestCategory> categoryOptions = adminInterestService.loadCategoryOptions();

    model.addAttribute("keyword", keyword);
    model.addAttribute("categoryOptions", categoryOptions);

    return "layout/admin/fragments/interest/keyword_modify :: KeywordModify";
  }

  // 카테고리명 수정
  @ResponseBody
  @PostMapping("/category/update/{no}/name")
  UpdateSuccess updateCategoryName(@PathVariable Long no, String name) {
    return adminInterestService.updateCategoryName(no, name);
  }

  // 카테고리 활성 상태 변경
  @ResponseBody
  @PostMapping("/category/update/{no}/state")
  UpdateSuccess updateCategoryState(@PathVariable Long no, boolean isActive) {
    return adminInterestService.updateCategoryState(no, isActive);
  }

  // 키워드 활성 상태 변경
  @ResponseBody
  @PostMapping("/keyword/update/{no}/state")
  UpdateSuccess updateKeywordState(@PathVariable Long no, boolean isActive) {
    return adminInterestService.updateKeywordState(no, isActive);
  }

  // 키워드 상세 정보 변경
  @ResponseBody
  @PostMapping("/keyword/update/{no}/info")
  UpdateSuccess updateKeywordInfo(@PathVariable Long no, AdminInterestKeyword keyword) {
    return adminInterestService.updateKeywordInfo(no, keyword);
  }

  // 카테고리 등록
  @PostMapping("/category/register")
  String registerCategory(HttpSession session, AdminInterestCategory category) {

    // 세션에서 관리자 객체 꺼내기
    Admin admin = (Admin) session.getAttribute("logined_admin");

    category.setAdminId(admin.getId());

    adminInterestService.registerCategory(category);

    return "redirect:/admin/management/interest/list";
  }

  // 키워드 등록
  @PostMapping("/keyword/register")
  String registerKeyword(HttpSession session, AdminInterestKeyword keyword) {

    // 세션에서 관리자 객체 꺼내기
    Admin admin = (Admin) session.getAttribute("logined_admin");

    keyword.setAdminId(admin.getId());

    adminInterestService.registerKeyword(keyword);

    return "redirect:/admin/management/interest/list";
  }

}
