package com.project.sf.admin.auth.controller;

import com.project.sf.admin.auth.model.AdminLogin;
import com.project.sf.admin.auth.service.AdminAuthService;
import com.project.sf.admin.operator.model.Admin;
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

    Admin logined = adminAuthService.login(adminLogin);

    if (logined != null) {
      session.setAttribute("logined_admin", logined);

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
