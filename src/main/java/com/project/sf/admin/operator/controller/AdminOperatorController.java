package com.project.sf.admin.operator.controller;

import com.project.sf.admin.operator.model.Admin;
import com.project.sf.admin.operator.service.AdminOperatorService;
import com.project.sf.common.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


// 운영자 관리 (SUPER만 접근 가능)
@Controller
@RequestMapping("/admin/management/operator")
public class AdminOperatorController {

  @Autowired
  AdminOperatorService adminOperatorService;

  @GetMapping("")
  String opreratorMain() {
    return "redirect:/admin/management/operator/list";
  }

  // 운영자 정보 조회 페이지
  @GetMapping("/list")
  String list(Model model, Pager pager) {

    pager.setPerPage(10);

    List<Admin> admins = adminOperatorService.loadAdmins(pager);

    model.addAttribute("admins", admins);

    return "pages/admin/management/operator/info/list";
  }

  // 운영자 정보 수정 페이지
  @GetMapping("/modify/{id}")
  String modify(@PathVariable String id, Model model) {

    Admin detail = adminOperatorService.loadAdminDetailById(id);

    model.addAttribute("detail", detail);

    return "pages/admin/management/operator/info/modify";
  }


  // 운영자 계정 생성 페이지
  @GetMapping("/register")
  String register() {
    return "pages/admin/management/operator/register/register";
  }

  // 운영자 권한 관리 페이지
  // authority 로 쓸까? 했지만 인터셉터와 헷갈릴 것 같아서 permission으로 통일
  @GetMapping("/permission")
  String permission() {
    return "pages/admin/management/operator/permission/permission";
  }
}
