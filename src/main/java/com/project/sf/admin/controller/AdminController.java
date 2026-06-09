package com.project.sf.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

  // 초기 화면 (관리자 대시보드 홈)
  @GetMapping("")
  String adminHome() {
    return "pages/admin/home";
  }

}
