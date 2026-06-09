package com.project.sf.admin.trend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.sf.trend.service.TrendService;

@Controller
@RequestMapping("/admin/management/interest")
public class AdminTrendController {
  @Autowired
  TrendService trendService;

  // 관심 분야 관리
  @GetMapping("/list")
  String main() {
    return "pages/admin/management/interest/list";
  }
}
