package com.project.sf.admins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.sf.admins.AdminLogin;
import com.project.sf.admins.Admins;
import com.project.sf.admins.service.AdminService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admins")
public class AdminsController {

  @Autowired
  AdminService adminService;

  @GetMapping("")
  String adminHome() {
    return "pages/admin/home";
  }

  @PostMapping("/login")
  String login(AdminLogin adminLogin, HttpSession session) {

    Admins logined = adminService.login(adminLogin);

    if (logined != null) {
      session.setAttribute("logined_admin", logined);
    }

    return "pages/admin/home";
  }
}
