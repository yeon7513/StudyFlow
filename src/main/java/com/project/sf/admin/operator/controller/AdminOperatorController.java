package com.project.sf.admin.operator.controller;

import com.project.sf.admin.operator.model.Admin;
import com.project.sf.admin.operator.service.AdminOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/admin/management/operator")
public class AdminOperatorController {

  @Autowired
  AdminOperatorService adminOperatorService;

  // 운영자 관리 (SUPER만 접근 가능)
  @GetMapping("/list")
  String list(Model model) {

    List<Admin> admins = adminOperatorService.loadAdmins();

    model.addAttribute("admins", admins);

    return "pages/admin/management/operator/list";
  }
}
