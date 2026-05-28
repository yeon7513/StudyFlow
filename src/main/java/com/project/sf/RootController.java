package com.project.sf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {

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
    return "admin/login";
  }

}
