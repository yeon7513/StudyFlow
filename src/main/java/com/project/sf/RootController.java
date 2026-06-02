package com.project.sf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.sf.admin.AdminLogin;
import com.project.sf.admin.Admin;
import com.project.sf.admin.service.AdminService;
import jakarta.servlet.http.HttpSession;

@Controller
public class RootController {

  @Autowired
  AdminService adminService;

  @GetMapping("/")
  String index() {
    return "index";
  }

  @PostMapping("/verify")
  boolean verify() {
    return false;
  }

  @GetMapping("/sf_admin_login")
  String login() {
    return "pages/admin/login";
  }

  @ResponseBody
  @PostMapping("/admin_login")
  boolean login(AdminLogin adminLogin, HttpSession session) {

    Admin logined = adminService.login(adminLogin);

    if (logined != null) {
      session.setAttribute("logined_admin", logined);

      return true;
    }

    return false;
  }

  @GetMapping("/admin_logout")
  String logout(HttpSession session) {
    session.removeAttribute("logined_admin");

    return "redirect:/";
  }

}
