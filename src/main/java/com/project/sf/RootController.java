package com.project.sf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

  @GetMapping("/")
  String index() {
    return "index";
  }

  @GetMapping("/sf-admin-login")
  String login() {
    return "admin/login";
  }

}
