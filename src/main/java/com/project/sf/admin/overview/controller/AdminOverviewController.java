package com.project.sf.admin.overview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/overview")
public class AdminOverviewController {

  // 운영 현황
  @GetMapping("")
  String displayOverview() {
    return "pages/admin/overview/overview";
  }

}
