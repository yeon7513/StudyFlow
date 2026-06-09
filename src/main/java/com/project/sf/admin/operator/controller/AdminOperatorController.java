package com.project.sf.admin.operator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/management/operator")
public class AdminOperatorController {


  // 운영자 관리 (SUPER만 접근 가능)
  @GetMapping("/list")
  String managementOperators() {
    return "pages/admin/management/operator/list";
  }
}
