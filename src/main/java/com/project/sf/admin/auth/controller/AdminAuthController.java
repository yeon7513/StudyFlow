package com.project.sf.admin.auth.controller;

import com.project.sf.admin.auth.model.AdminLogin;
import com.project.sf.admin.auth.service.AdminAuthService;
import com.project.sf.admin.operator.model.Admin;
import com.project.sf.common.enums.operator.AdminRoleEnum;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/auth")
public class AdminAuthController {

  @Autowired
  AdminAuthService adminAuthService;


  @GetMapping("/login")
  String login(HttpSession session) {

    if (session.getAttribute("logined_admin") != null) {
      return "redirect:admin";
    }

    return "pages/admin/login";
  }

  @ResponseBody
  @PostMapping("/login")
  boolean login(AdminLogin adminLogin, HttpSession session) {

    Admin loginedAdmin = adminAuthService.login(adminLogin);

    // 관리자일 경우
    if (loginedAdmin != null) {

      // 단, 비활성이면 통과 X
      if (!loginedAdmin.isActive()) {
        return false;
      }

      // 권한을 한글로 변경 후
      loginedAdmin.setRolesWithLabel(AdminRoleEnum.changeValueToLabel(loginedAdmin.getRole()));
      // 세션에 저장
      session.setAttribute("logined_admin", loginedAdmin);

      return true;
    }

    return false;
  }

  @GetMapping("/logout")
  String logout(HttpSession session) {
    session.removeAttribute("logined_admin");

    return "redirect:/";
  }
}
