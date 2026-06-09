package com.project.sf.admin.blacklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/management/blacklist")
public class AdminBlacklistController {

  // 블랙리스트 관리
  @GetMapping("/list")
  String managementBlacklists() {
    return "pages/admin/management/blacklist/list";
  }
}
