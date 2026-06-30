package com.project.sf.admin.operator.controller;

import com.project.sf.admin.operator.model.Admin;
import com.project.sf.admin.operator.service.AdminOperatorService;
import com.project.sf.common.enums.operator.AdminRoleEnum;
import com.project.sf.common.model.UpdateSuccess;
import com.project.sf.common.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // 화면에 렌더링할 권한들 (ENUM으로 넘겨줌)
    model.addAttribute("roleOptions", AdminRoleEnum.values());

    return "pages/admin/management/operator/list";
  }

  // 운영자 정보 수정
  @ResponseBody
  @PostMapping("/modify/{id}")
  UpdateSuccess modify(@PathVariable String id, Admin admin) {
    admin.setId(id);
    return adminOperatorService.modifyAdmin(admin);
  }

  // 운영자 계정 생성 페이지
  @GetMapping("/register")
  String register(Model model) {

    // 권한 선택 체크박스 렌더링
    model.addAttribute("roleOptions", AdminRoleEnum.values());

    return "pages/admin/management/operator/register";
  }

  // 운영자 아이디 검증 로직
  @ResponseBody
  @GetMapping("/check_id/{id}")
  boolean checkId(@PathVariable String id) {
    return adminOperatorService.checkId(id);
  }

  // 운영자 계정 생성
  @PostMapping("/register")
  String registerAdminAccount(Admin admin) {

    adminOperatorService.registerAdminAccount(admin);

    return "redirect:/admin/management/operator/list";
  }

}
