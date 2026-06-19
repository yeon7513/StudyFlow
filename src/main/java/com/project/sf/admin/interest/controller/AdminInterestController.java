package com.project.sf.admin.interest.controller;

import com.project.sf.admin.interest.model.AdminInterestCategory;
import com.project.sf.admin.interest.model.AdminInterestKeyword;
import com.project.sf.admin.interest.service.AdminInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/management/interest")
public class AdminInterestController {

  @Autowired
  AdminInterestService adminInterestService;

  // 관심 분야 관리
  @GetMapping("/list")
  String list(Model model) {

    // 등록된 카테고리 수
    int totalCategoryCount = adminInterestService.totalCategoryCount();

    // 등록된 키워드 수
    int totalKeywordCount = adminInterestService.totalKeywordCount();

    // 비어있는 카테고리 수 -> 키워드가 등록되지 않은 카테고리

    // 키워드 운영 상태 -> 활성 00건 / 비활성 00건

    // 최초 진입 시에는 카테고리 패널 렌더링
    List<AdminInterestCategory> category = adminInterestService.loadCategories();
    model.addAttribute("category", category);

    return "pages/admin/management/interest/list";
  }

  // 카테고리 패널
  @GetMapping("/category")
  String category(Model model) {

    List<AdminInterestCategory> category = adminInterestService.loadCategories();

    model.addAttribute("category", category);

    return "layout/admin/fragments/interest/category_panel :: CategoryPanel";
  }

  // 키워드 패널
  @GetMapping("/keyword")
  String keyword(Model model) {

    List<AdminInterestKeyword> keyword = adminInterestService.loadKeywords();

    model.addAttribute("keyword", keyword);

    return "layout/admin/fragments/interest/keyword_panel :: KeywordPanel";
  }
}
