package com.project.sf;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

  @GetMapping("/")
  String index() {
    return "index";
  }

  @GetMapping("/no_permission")
  String noPermission(HttpSession session) {

    // 혹시 남을 수도 있는 로그인 정보 세션을 초기화
    session.invalidate();

    return "error/no_permission";
  }

}
