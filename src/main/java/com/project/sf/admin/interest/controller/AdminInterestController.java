package com.project.sf.admin.interest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/management/interest")
public class AdminInterestController {


  // 관심 분야 관리
  @GetMapping("/list")
  String list(Model model) {


    return "pages/admin/management/interest/list";
  }
}
